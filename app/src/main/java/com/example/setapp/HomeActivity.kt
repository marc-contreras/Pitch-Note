package com.example.setapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType() {
    BASIC
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // SETUP

        val bundle: Bundle? = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider?: "")
    }

    private fun setup(email: String, provider: String) {

        var emailtextView = findViewById<TextView>(R.id.EmailtextView)
        var providerTextView = findViewById<TextView>(R.id.ProviderTextView)
        var closeSessionButton = findViewById<Button>(R.id.closeSessionButton)
        var notePitchButton = findViewById<Button>(R.id.abutton)

        title = "Inici"
        emailtextView.text = email
        providerTextView.text = provider

        notePitchButton.setOnClickListener(){
            goToExercice()
        }

        closeSessionButton.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            //onBackPressed()
            goToActivity()
        }
    }

    private fun goToActivity() {
        val homeIntent = Intent(this, AuthActivity::class.java)
        startActivity(homeIntent)
    }

    private fun goToExercice() {
        val homeIntent = Intent(this, PitchNoteActivity::class.java)
        startActivity(homeIntent)
    }
}