package com.example.setapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private const val TAG = "MyActivity"

class RegistrarUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        // SETUP

        setup()

    }

    private fun setup() {

        var signUpButton = findViewById<Button>(R.id.signUpButton)
        var backButton = findViewById<Button>(R.id.volverButton)
        var editTextName = findViewById<EditText>(R.id.editTextPersonName)
        var editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        var editTextTextEmailAddress = findViewById<EditText>(R.id.editTextEmailAddress)
        var editTextTextPassword = findViewById<EditText>(R.id.editTextPassword)
        var database : DatabaseReference

        title = "autenticació"

        signUpButton.setOnClickListener {
            Log.d(TAG, editTextTextEmailAddress.text.toString()+" "+editTextTextPassword.text.toString() + "INFOOOO")
            if (editTextTextEmailAddress.text.isNotEmpty() && editTextTextPassword.text.isNotEmpty() ) {
                Log.d(TAG, "He entrado contra y pass")
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(editTextTextEmailAddress.text.toString(),
                        editTextTextPassword.text.toString()).addOnCompleteListener(){
                        if(it.isSuccessful) {
                            Log.d(TAG, "viva")
                            database = FirebaseDatabase.getInstance().getReference("Usuarios")
                            val user = Usuario(editTextName.text.toString(), editTextPhone.text.toString().toInt(), FirebaseAuth.getInstance().uid.toString() )
                            database.child(editTextName.text.toString()).setValue(user).addOnSuccessListener {
                                Toast.makeText(this, "Usuario Creado", Toast.LENGTH_SHORT).show()
                            }.addOnFailureListener {
                                Toast.makeText(this, "Correo incorrecto o no existe", Toast.LENGTH_SHORT).show()
                            }
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert("S'ha produit un error autenticant l'usuari")
                        }
                    }
            }
        }

        backButton.setOnClickListener {
            Log.d(TAG, "movemos a menú logging")
            onBackPressed()
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
}