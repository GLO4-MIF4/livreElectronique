package com.example.livreinformatique

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class Progression : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progression)

        findViewById<ImageButton>(R.id.home).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.cours_24).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Cours_update::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.quiz_24).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Quiz::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.exercice_24).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Exercices::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.jargon_24).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Jargon::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })


    }
}