package com.example.setapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
private const val TAG = "MyActivity"

class AuthActivity : AppCompatActivity() {
    var stateMain: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {

        //Thread.sleep(2000) Descomentar cuando probemos el splash

        setTheme(R.style.Theme_SETApp)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // SETUP

        setup()

    }

    private fun setup() {

        var signUpButton = findViewById<Button>(R.id.signUpButton)
        var accessButton = findViewById<Button>(R.id.volverButton)
        var editTextTextEmailAddress = findViewById<EditText>(R.id.editTextEmail)
        var editTextTextPassword = findViewById<EditText>(R.id.editTextPassword)

        title = "autenticació"

        signUpButton.setOnClickListener {
            Log.d(TAG, editTextTextEmailAddress.text.toString()+" "+editTextTextPassword.text.toString()+ " vamos a registrar")
            editTextTextEmailAddress.text.clear()
            editTextTextPassword.text.clear()
            showUserRegisterActivity()
        }

        accessButton.setOnClickListener {
            if (editTextTextEmailAddress.text.isNotEmpty() && editTextTextPassword.text.isNotEmpty() ) {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextTextEmailAddress.text.toString(),
                    editTextTextPassword.text.toString()).addOnCompleteListener(){
                    if(it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        editTextTextEmailAddress.text.clear()
                        editTextTextPassword.text.clear()
                    } else {
                        showAlert("Error a l'iniciar Sessió")
                        editTextTextPassword.text.clear()
                    }
                }
            }
        }
    }

    private fun showAlert(errorText: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(errorText)
        builder.setPositiveButton("Acceptar", null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider)
        }
        startActivity(homeIntent)
    }

    private fun showUserRegisterActivity() {
        val homeIntent = Intent(this, RegistrarUsuario::class.java)
        startActivity(homeIntent)
    }
}