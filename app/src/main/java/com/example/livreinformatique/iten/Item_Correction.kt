package com.example.livreinformatique.iten

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.livreinformatique.*
import java.util.ArrayList

class item_Correction : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_correction)

        val correction = intent.getStringArrayListExtra("corrections")
        val position = intent.getIntExtra("position",0)

        ListCorrction(correction,position)

        findViewById<Button>(R.id.iten_correctionCC).setOnClickListener(View.OnClickListener {
            var intent = Intent(this,itemExercices::class.java)
            intent.putExtra("position",position)
            startActivity(intent)
        })

        findViewById<Button>(R.id.iten_quizCC).setOnClickListener(View.OnClickListener {
            var intent = Intent(this,iten_quiz::class.java)
            intent.putExtra("position",position)
            startActivity(intent)

        })

        findViewById<Button>(R.id.iten_coursCC).setOnClickListener(View.OnClickListener {
            var intent = Intent(this,item_courts::class.java)
            intent.putExtra("position",position)
            startActivity(intent)

        })



    }
    fun ListCorrction(exercice: ArrayList<String>?, position: Int){

        var body  = findViewById<LinearLayout>(R.id.body_iten_correction)

        findViewById<TextView>(R.id.iten_numero_coor).text = " : $position"

        for (i in body.childCount - 1 downTo 0) {
            val child = body.getChildAt(i)
            body.removeView(child)
        }

        var numeroQuestion :Int = 1

        if (exercice != null) {
            exercice.forEach {
                // créer un objet TextView
                val textView = TextView(this)

                // définir le texte et la couleur du TextView
                textView.text = "$numeroQuestion : $it"
                textView.textSize = 20F

                // ajouter le TextView à l'activité
    //        setContentView(textView)
                body.addView(textView)

                numeroQuestion ++
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pricipal, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_item_2 -> {
                startActivity(Intent(this, Cours_update::class.java))
                true
            }
            R.id.menu_item_3 -> {
                startActivity(Intent(this, Exercices::class.java))
                true
            }
            R.id.menu_item_4 -> {
                startActivity(Intent(this, Jargon::class.java))
                true
            }
            R.id.menu_item_5 -> {
                startActivity(Intent(this, Quiz::class.java))
                true
            }
            R.id.menu_item_6 -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}