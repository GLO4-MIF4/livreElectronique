package com.example.livreinformatique.iten

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.livreinformatique.*
import org.xmlpull.v1.XmlPullParser


class Exercice(var questions: List<String>, var correction: List<String>)


class itemExercices : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_exercices)




//-----------------------------------------------------------------------------------------------------


        val Exercices = mutableListOf<Exercice>()
// Variables pour stocker les informations de chaque livre

        var question: String? = null
        var correction: String? = null
        var questions = mutableListOf<String>()
        var corrections = mutableListOf<String>()
        val parser = resources.getXml(R.xml.exercices_file)

// Boucle pour parcourir le fichier XML et extraire les informations de chaque livre

        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            when (parser.eventType) {
                XmlPullParser.START_TAG -> {
                    when (parser.name) {
                        "questions" -> {
                            // Nouvelle question trouvé, réinitialiser les variables
                            question = null
                            questions = mutableListOf<String>()
//                            correction = null
//                            corrections = listOf<String>()
                            parser.next()
                            while (parser.name == "question"){
                                question = parser.nextText()
                                questions.add(question)
                                question = null
                                parser.next()
                            }
                        }

                        "corrections" -> {
                            // Nouvelle corrections trouvé, réinitialiser les variables
//                            question = null
//                            questions = mutableListOf<String>()

                            correction = null
                            corrections = mutableListOf<String>()
                            parser.next()
                            while (parser.name == "correction"){
                                correction = parser.nextText()
                                corrections.add(correction)
                                correction = null
                                parser.next()
                            }
                        }

                    }
                }
                XmlPullParser.END_TAG -> {
                    if (parser.name == "exercice") {
                        // Fin du livre, ajouter un nouvel objet Book à la liste
                        Exercices.add(Exercice(questions,corrections))
                    }
                }
            }
        }
        Exercices

//--------------------------------------------------------------------------------------------------

//  -------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------
        findViewById<Button>(R.id.iten_correctionE).setOnClickListener(View.OnClickListener {
            var position  = findViewById<TextView>(R.id.textPrevExo).text

            var position2:Int
            if (position == " "){ position2 = 0
                var intent = Intent(this,item_Correction::class.java)
                intent.putExtra("position",position2)
                intent.putStringArrayListExtra("corrections", Exercices[position2].correction as ArrayList<String>)
                startActivity(intent)}
            else{position2 = Integer.parseInt(position as String)
                var intent = Intent(this,item_Correction::class.java)
                intent.putExtra("position",position2 +1)
                intent.putStringArrayListExtra("corrections", Exercices[position2].correction as ArrayList<String>)
                startActivity(intent)}

        })

        findViewById<Button>(R.id.iten_quizE).setOnClickListener(View.OnClickListener {
            var position  = findViewById<TextView>(R.id.textPrevExo).text

            var position2:Int
            if (position == " "){ position2 = 0
                var intent = Intent(this,iten_quiz::class.java)
                intent.putExtra("position",position2)
                startActivity(intent)
            }
            else{position2 = Integer.parseInt(position as String)
                var intent = Intent(this,iten_quiz::class.java)
                intent.putExtra("position",position2 +1)
                startActivity(intent)
            }


        })

        findViewById<Button>(R.id.iten_coursE).setOnClickListener(View.OnClickListener {
            var position  = findViewById<TextView>(R.id.textPrevExo).text

            var position2:Int
            if (position == " "){ position2 = 0
                var intent = Intent(this,item_courts::class.java)
                intent.putExtra("position",position2)

                startActivity(intent)}
            else{position2 = Integer.parseInt(position as String)
                var intent = Intent(this,item_courts::class.java)
                intent.putExtra("position",position2 +1 )

                startActivity(intent)}

        })


        val prev : ImageButton = findViewById(R.id.previuosExo)
        val next : ImageButton = findViewById(R.id.nextExo)
        val textPrev = findViewById<TextView>(R.id.textPrevExo)
        val textNext = findViewById<TextView>(R.id.textNextExo)
        val pointer = findViewById<TextView>(R.id.pointerExo)

        var position = intent.getIntExtra( "position",0)



//        ---------------------------------------------------------



        ListExo( Exercices[position].questions ,position)

//       -----------------------------------


//        element neutre

        var itenLecon : TextView  = pointer
//        var containCourse : Array<String> = listOf("","", "").toTypedArray()
//        ------------------------------------------------------------------
        var containCourse : Array<String> = resources.getStringArray(R.array.lecons)
        if (position  == 0){
            previous(prev, textPrev, textNext, itenLecon, containCourse, pointer, 0)
        }else if(position == containCourse.size -1){
            next(prev, textPrev, textNext, itenLecon, containCourse, pointer, containCourse.size-1)
        }else{
            previous(prev, textPrev, textNext, itenLecon, containCourse, pointer, position)
        }


        prev.setOnClickListener(View.OnClickListener {
            var contain: Int
            if (textPrev.text == " ") {
                contain = 0
            } else {
                contain = Integer.parseInt(textPrev.text as String)
            }
            previous(it,textPrev,textNext,itenLecon, containCourse,pointer,contain)
            ListExo(Exercices[contain].questions, contain)
        })

        next.setOnClickListener(View.OnClickListener {
            var contain: Int

            if (textNext.text == " "){
                contain  = containCourse.size -1
            }else{
                contain = Integer.parseInt(textNext.text as String)
            }

            next(it,textPrev,textNext,itenLecon, containCourse,pointer, contain)
            ListExo(Exercices[contain].questions, contain)

        })
    }
    fun ListExo(exercice: List<String>, position: Int){

        var body  = findViewById<LinearLayout>(R.id.body_iten_exercice)

        findViewById<TextView>(R.id.iten_numero_exo).text = " : $position"

        for (i in body.childCount - 1 downTo 0) {
            val child = body.getChildAt(i)
            body.removeView(child)
        }




        var numeroQuestion :Int = 1
        exercice.forEach {


            val linearLayoutParent = LinearLayout(this)
            linearLayoutParent.orientation = LinearLayout.HORIZONTAL
//            linearLayoutParent.elevation = 10f
            linearLayoutParent.setBackgroundColor(Color.WHITE)

            var paramsParent = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )


            var paramsParent1 = GradientDrawable()
            paramsParent1.setColor(Color.TRANSPARENT)
            paramsParent1.setStroke(resources.getDimensionPixelSize(com.google.android.material.R.dimen.m3_fab_border_width), Color.BLACK)
            paramsParent1.setCornerRadius(resources.getDimension(androidx.constraintlayout.widget.R.dimen.abc_control_corner_material))

            paramsParent.setMargins(10,10,10,10)
            linearLayoutParent.layoutParams = paramsParent
            linearLayoutParent.background = paramsParent1
//            ......................number.........................

            val linearLayoutNumber = LinearLayout(this)
            linearLayoutNumber.elevation = 2f

            val paramsNumber = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
            linearLayoutNumber.setBackgroundColor(Color.WHITE)
            linearLayoutNumber.layoutParams = paramsNumber

//            ....................... exercice.......................

            val linearLayout = LinearLayout(this)
            linearLayout.elevation = 2f

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )


            linearLayout.setBackgroundColor(Color.WHITE)
            linearLayout.layoutParams = params


            val textViewNumber = TextView(this)

            textViewNumber.text = "$numeroQuestion : "
            textViewNumber.textSize = 20F

            linearLayoutNumber.addView(textViewNumber)

            // créer un objet TextView
            val textView = TextView(this)

            // définir le texte et la couleur du TextView
            textView.text = " $it"
            textView.textSize = 20F
            linearLayout.addView(textView)

            // ajouter le TextView à l'activité
//        setContentView(textView)
            //            ..................addView...........................

            linearLayoutParent.addView(linearLayoutNumber)
            linearLayoutParent.addView(linearLayout)
            body.addView(linearLayoutParent)

            numeroQuestion++
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
                startActivity(Intent(this,Exercices::class.java))
                true
            }
            R.id.menu_item_4 -> {
                startActivity(Intent(this,Jargon::class.java))
                true
            }
            R.id.menu_item_5 -> {
                startActivity(Intent(this,Quiz::class.java))
                true
            }
            R.id.menu_item_6 -> {
                startActivity(Intent(this,MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

