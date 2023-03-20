package com.example.livreinformatique.connexion

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.livreinformatique.MainActivity
import com.example.livreinformatique.R
import com.example.livreinformatique.sqlite.Bd_Users

class Connexion : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)

        findViewById<Button>(R.id.inscription).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Inscription::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<Button>(R.id.connexion).setOnClickListener(View.OnClickListener {

            var nom :EditText = findViewById(R.id.nomCon)
            var password :EditText = findViewById(R.id.passwordConn)

            val dbHelper = Bd_Users(this)
            val db = dbHelper.readableDatabase

            var name = nom.text.toString()

            val cursor = db.rawQuery("SELECT PASSWORD FROM USERS WHERE NOM = ?", arrayOf(name))

            if (cursor.moveToFirst()) {
                val password2 = cursor.getString(cursor.getColumnIndex("PASSWORD"))

                if(password2 ==password.text.toString() ){
                    startActivity(Intent(this,MainActivity::class.java))
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
                    finish()
                }
            } else {
                Toast.makeText(this, "verifiez vos informations", Toast.LENGTH_SHORT).show()
            }
        })


    }
}