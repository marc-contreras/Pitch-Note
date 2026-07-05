package com.example.setapp

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt
private const val TAG = "Pitch"

class PitchNoteActivity : AppCompatActivity() {
    lateinit var soundPool: SoundPool // creació de constants on guardo tots els sons
    var notaAleatoria: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pitch_note)
        notaAleatoria = getRandomNote()
        Log.d(TAG, "Prueba1: " + notaAleatoria)
        setup()
    }

    private fun setup() {
        var listenButton = findViewById<Button>(R.id.listenButton)
        var closeSessionButton = findViewById<Button>(R.id.closeSessionButton)
        var aButton = findViewById<Button>(R.id.aButton)
        var asButton = findViewById<Button>(R.id.asButton)
        var bButton = findViewById<Button>(R.id.bButton)
        var cButton = findViewById<Button>(R.id.cButton)
        var csButton = findViewById<Button>(R.id.csButton)
        var dButton = findViewById<Button>(R.id.dButton)
        var dsButton = findViewById<Button>(R.id.dsButton)
        var eButton = findViewById<Button>(R.id.eButton)
        var fButton = findViewById<Button>(R.id.fButton)
        var fsButton = findViewById<Button>(R.id.fsButton)
        var gButton = findViewById<Button>(R.id.gButton)
        var gsButton = findViewById<Button>(R.id.gsButton)

        var resposta = findViewById<TextView>(R.id.resposta)


        soundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool.load(baseContext, R.raw.a, 1)
        soundPool.load(baseContext, R.raw.`as`, 2)
        soundPool.load(baseContext, R.raw.b, 3)
        soundPool.load(baseContext, R.raw.c, 4)
        soundPool.load(baseContext, R.raw.cs, 5)
        soundPool.load(baseContext, R.raw.d, 6)
        soundPool.load(baseContext, R.raw.ds, 7)
        soundPool.load(baseContext, R.raw.e, 8)
        soundPool.load(baseContext, R.raw.f, 9)
        soundPool.load(baseContext, R.raw.fs, 10)
        soundPool.load(baseContext, R.raw.g, 11)
        soundPool.load(baseContext, R.raw.gs, 12)

        closeSessionButton.setOnClickListener(){
            //onBackPressed()
            goToActivity()
        }

        listenButton.setOnClickListener(){
            aButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            asButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            bButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            cButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            csButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            dButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            dsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            eButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            fButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            fsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            gButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            gsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))

            Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
            playsound(notaAleatoria)
            resposta.text = "Escull la nota correcta"
            Thread.sleep(500) // Afegim un delay
        }

        aButton.setOnClickListener(){
            if(notaAleatoria == 1){
                aButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        asButton.setOnClickListener(){
            if(notaAleatoria == 2){
                asButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        bButton.setOnClickListener(){
            if(notaAleatoria == 3){
                bButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        cButton.setOnClickListener(){
            if(notaAleatoria == 4){
                cButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        csButton.setOnClickListener(){
            if(notaAleatoria == 5){
                csButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        dButton.setOnClickListener(){
            if(notaAleatoria == 6){
                dButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        dsButton.setOnClickListener(){
            if(notaAleatoria == 7){
                dsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        eButton.setOnClickListener(){
            if(notaAleatoria == 8){
                eButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        fButton.setOnClickListener(){
            if(notaAleatoria == 9){
                fButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        fsButton.setOnClickListener(){
            if(notaAleatoria == 10){
                fsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        gButton.setOnClickListener(){
            if(notaAleatoria == 11){
                gButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

        gsButton.setOnClickListener(){
            if(notaAleatoria == 12){
                gsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.successColor))
                resposta.text = "Correcte, escolta la nota següent"
                Log.d(TAG, "Nota aleatoria BEFORE = " + notaAleatoria)
                notaAleatoria = getRandomNote()
                Log.d(TAG, "Nota aleatoria AFTER = " + notaAleatoria)

            }
            else{
                resposta.text = "Torna a provar"
            }
        }

    }

    private fun goToActivity() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
    }

    private fun playsound (num: Int) {
        soundPool.play(num, 1F, 1F, 0, 0, 1F)
    }

    private fun getRandomNote():Int{
        return ((Math.random() * 12)+1).toInt()
    }



}