package com.example.livreinformatique.connexion

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.livreinformatique.R
import com.example.livreinformatique.sqlite.Bd_Users

class Inscription : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        findViewById<Button>(R.id.connexionI).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Connexion::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<Button>(R.id.inscriptionI).setOnClickListener(View.OnClickListener {


            var nom :EditText = findViewById(R.id.nom)
            var password :EditText = findViewById(R.id.password)
            var password2 :EditText = findViewById(R.id.password2)
            var email :EditText = findViewById(R.id.email)

            var pass1 = password.text.toString()
            var pas2 = password2.text.toString()
            if ( pass1 == pas2 ){

                val dbHelper = Bd_Users(this)
                val db = dbHelper.writableDatabase


                val values = ContentValues().apply {
                    put("NOM", nom.text.toString())
                    put("PASSWORD", password.text.toString())
                    put("EMAIL", email.text.toString())
                }

                val newRowId = db.insert("USERS", null, values)
                if (newRowId == -1L) {
// L'insertion a échoué
                    Toast.makeText(this,"Erreur lors de l'INSCRIPTION!",Toast.LENGTH_SHORT).show()
                } else {
// L'insertion a réussi

                    Toast.makeText(this,"INSCRIPTION réussie avec SUCCES",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,Connexion::class.java))
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
                    finish()

                }

                dbHelper.close()
            }
            else{
                Toast.makeText(this, "verifiez le nom de passe", Toast.LENGTH_SHORT).show()
            }



        })

    }
}