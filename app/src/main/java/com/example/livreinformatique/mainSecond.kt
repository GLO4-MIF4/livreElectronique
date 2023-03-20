package com.example.livreinformatique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainSecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second)

        var buttonQuiz:Button = findViewById(R.id.Quiz_main)
        buttonQuiz.setOnClickListener(View.OnClickListener {
            change()
        })

    }

    fun change() {
        val intent  = Intent(this,Quiz::class.java)
        startActivity(intent)

    }
}