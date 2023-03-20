package com.example.livreinformatique.iten

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.livreinformatique.*
import org.xmlpull.v1.XmlPullParser


class Quiz(var question: MutableList<Question_quiz>)

class Question_quiz(var question:String ,
                var answer : MutableList<String>,
                var feedback : String)

class iten_quiz : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iten_quiz)


//-----------------------------------------------------------------------------------------------------


        val Quizs = mutableListOf<Quiz>()
// Variables pour stocker les informations de chaque livre
        var Ques :String =""
        var feedback: String =""
        var questions = mutableListOf<Question_quiz>()
        var answers = mutableListOf<String>()
        val parser = resources.getXml(R.xml.quiz)

// Boucle pour parcourir le fichier XML et extraire les informations de chaque livre

        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            when (parser.eventType) {
                XmlPullParser.START_TAG -> {
                    when (parser.name) {
                        "question" -> {
//                            questions = mutableListOf<Question>()
                            answers = mutableListOf<String>()
                        }
                        "text" ->{
                            Ques = parser.nextText()
                        }

                        "feedback" ->{
                            feedback = parser.nextText()
                        }

                        "answer" ->{
                            answers.add(parser.nextText())
                        }
                    }
                }
                XmlPullParser.END_TAG -> {

                    if (parser.name == "question") {
                            questions.add(Question_quiz(Ques,answers,feedback))
                    }
                    if (parser.name == "quiz"){
//                        fin de la question
                        Quizs.add(Quiz(questions))
                        questions = mutableListOf<Question_quiz>()

                    }
                }
            }
        }
     Quizs

//--------------------------------------------------------------------------------------------------

//  -------------------------------------------------------------------------------------------------




//        remplicage des questionnaires : quiz  --------------------------------------------------
//        val res : Resources = resources

        var question1  :TextView = findViewById(R.id.question1)
        var question2  :TextView = findViewById(R.id.question2)
        var question3  :TextView = findViewById(R.id.question3)
        var question4 :TextView = findViewById(R.id.question4)
        var question5  :TextView = findViewById(R.id.question5)
//        var question6  :TextView = findViewById(R.id.question6)
//        var question7  :TextView = findViewById(R.id.question7)
//        var question8  :TextView = findViewById(R.id.question8)
//        var question9  :TextView = findViewById(R.id.question9)
//        var question10  :TextView = findViewById(R.id.question10)


        var question1qcm1 :RadioButton = findViewById(R.id.question1qcm1)
        var question1qcm2 :RadioButton = findViewById(R.id.question1qcm2)
        var question1qcm3 :RadioButton = findViewById(R.id.question1qcm3)
        var question1qcm4 :RadioButton = findViewById(R.id.question1qcm4)

        var question2qcm1 :RadioButton = findViewById(R.id.question2qcm1)
        var question2qcm2 :RadioButton = findViewById(R.id.question2qcm2)
        var question2qcm3 :RadioButton = findViewById(R.id.question2qcm3)
        var question2qcm4 :RadioButton = findViewById(R.id.question2qcm4)

        var question3qcm1 :RadioButton = findViewById(R.id.question3qcm1)
        var question3qcm2 :RadioButton = findViewById(R.id.question3qcm2)
        var question3qcm3 :RadioButton = findViewById(R.id.question3qcm3)
        var question3qcm4 :RadioButton = findViewById(R.id.question3qcm4)

        var question4qcm1 :RadioButton = findViewById(R.id.question4qcm1)
        var question4qcm2 :RadioButton = findViewById(R.id.question4qcm2)
        var question4qcm3 :RadioButton = findViewById(R.id.question4qcm3)
        var question4qcm4 :RadioButton = findViewById(R.id.question4qcm4)
//
        var question6qcm1 :RadioButton = findViewById(R.id.question5qcm1)
        var question6qcm2 :RadioButton = findViewById(R.id.question5qcm2)
        var question6qcm3 :RadioButton = findViewById(R.id.question5qcm3)
        var question6qcm4 :RadioButton = findViewById(R.id.question5qcm4)

//        var question7qcm1 :RadioButton = findViewById(R.id.question7qcm1)
//        var question7qcm2 :RadioButton = findViewById(R.id.question7qcm2)
//        var question7qcm3 :RadioButton = findViewById(R.id.question7qcm3)
//        var question7qcm4 :RadioButton = findViewById(R.id.question7qcm4)
//
//        var question8qcm1 :RadioButton = findViewById(R.id.question8qcm1)
//        var question8qcm2 :RadioButton = findViewById(R.id.question8qcm2)
//        var question8qcm3 :RadioButton = findViewById(R.id.question8qcm3)
//        var question8qcm4 :RadioButton = findViewById(R.id.question8qcm4)
//
//        var question5qcm1 :RadioButton = findViewById(R.id.question5qcm1)
//        var question5qcm2 :RadioButton = findViewById(R.id.question5qcm2)
//        var question5qcm3 :RadioButton = findViewById(R.id.question5qcm3)
//        var question5qcm4 :RadioButton = findViewById(R.id.question5qcm4)
//
//        var question9qcm1 :RadioButton = findViewById(R.id.question9qcm1)
//        var question9qcm2 :RadioButton = findViewById(R.id.question9qcm2)
//        var question9qcm3 :RadioButton = findViewById(R.id.question9qcm3)
//        var question9qcm4 :RadioButton = findViewById(R.id.question9qcm4)
//
//        var question10qcm1 :RadioButton = findViewById(R.id.question10qcm1)
//        var question10qcm2 :RadioButton = findViewById(R.id.question10qcm2)
//        var question10qcm3 :RadioButton = findViewById(R.id.question10qcm3)
//        var question10qcm4 :RadioButton = findViewById(R.id.question10qcm4)



        val prev : ImageButton = findViewById(R.id.previuos)
        val next : ImageButton = findViewById(R.id.next)
        val textPrev = findViewById<TextView>(R.id.textPrev)
        val textNext = findViewById<TextView>(R.id.textNext)
        val pointer = findViewById<TextView>(R.id.pointerLecon)


        val itenLecon = findViewById<TextView>(R.id.itenLecon1)

        var position = intent.getIntExtra( "position",0)

        val res : Resources = resources
        val  containCourse : Array<String> = res.getStringArray(R.array.lecons)

        val  containQuestion : Array<String> = res.getStringArray(R.array.question)
        val  containValue : Array<String> = res.getStringArray(R.array.values)

//            .....................................................................................

        remplissageQuiz( Quizs[position])
//...............................................................................................
        if (position  == 0){
            previous(prev, textPrev, textNext, itenLecon, containCourse, pointer, 0)
        }else if(position == containCourse.size -1){
            next(prev, textPrev, textNext, itenLecon, containCourse, pointer, containCourse.size -1)
        }else{
            previous(prev, textPrev, textNext, itenLecon, containCourse, pointer, position)
        }


        next.setOnClickListener(View.OnClickListener {
            var contain: Int

            if (textNext.text == " "){
                contain  = containCourse.size-1
            }else{
                contain = Integer.parseInt(textNext.text as String)
            }
            Reset ()
            remplissageQuiz( Quizs[contain])
            next(it,textPrev,textNext,itenLecon, containCourse,pointer, contain)

        })


        prev.setOnClickListener(View.OnClickListener {
            var contain: Int
            if (textPrev.text == " "){
                contain  = 0
            }else{
                contain = Integer.parseInt(textPrev.text as String)
            }
            Reset ()
            remplissageQuiz( Quizs[contain])
            previous(it,textPrev,textNext,itenLecon, containCourse,pointer,contain)

        })


        findViewById<Button>(R.id.save).setOnClickListener(View.OnClickListener {
            var position  = findViewById<TextView>(R.id.textPrev).text
            var position2:Int
            if (position == " "){
                Save(Quizs[0])
            }
            else{
                position2 = Integer.parseInt(position as String)
                Save(Quizs[position2+1])
            }
        })

        findViewById<Button>(R.id.reset).setOnClickListener(View.OnClickListener {
            Reset()
        })

        findViewById<Button>(R.id.correction).setOnClickListener(View.OnClickListener {
            var position  = findViewById<TextView>(R.id.textPrev).text
            var position2:Int
            if (position == " "){ position2 = 0
                Correction(Quizs[position2])}
            else{position2 = Integer.parseInt(position as String)
                Correction(Quizs[position2 +1])}
        })

        findViewById<Button>(R.id.cours_quiz).setOnClickListener(View.OnClickListener {
            var position  = findViewById<TextView>(R.id.textPrev).text

            var position2:Int
            if (position == " "){ position2 = 0
                var intent = Intent(this,item_courts::class.java)
                intent.putExtra("position",position2)
                startActivity(intent)}
            else{position2 = Integer.parseInt(position as String)
                var intent = Intent(this,item_courts::class.java)
                intent.putExtra("position",position2 +1)
                startActivity(intent)}


        })

        findViewById<Button>(R.id.exerxices_quiz).setOnClickListener(View.OnClickListener {
            var position  = findViewById<TextView>(R.id.textPrev).text

            var position2:Int
            if (position == " "){ position2 = 0
                var intent = Intent(this,itemExercices::class.java)
                intent.putExtra("position",position2 )
                startActivity(intent)}
            else{position2 = Integer.parseInt(position as String)
                var intent = Intent(this,itemExercices::class.java)
                intent.putExtra("position",position2 + 1)
                startActivity(intent)}



        })

        findViewById<Button>(R.id.Ressayer).setOnClickListener(View.OnClickListener {
            findViewById<LinearLayout>(R.id.blocknote).visibility =View.GONE
            findViewById<Button>(R.id.save).isEnabled = true
            Reset()
        })

        findViewById<LinearLayout>(R.id.blocknote).visibility =View.GONE


    }
    private fun Reset (){
        var contenuQuiz:LinearLayout  =  findViewById(R.id.contenu_quiz)

        for (i in contenuQuiz.childCount - 1 downTo 0) {
            var child = contenuQuiz.getChildAt(i)

            if (child is LinearLayout){

                for (j in child.childCount - 1 downTo 0) {
                    val child2 = child.getChildAt(j)

                    if (child2 is LinearLayout){

                        for (k in child2.childCount - 1 downTo 0) {
                            val child3 = child2.getChildAt(k)

                            if (child3 is RadioGroup){

                                for (l in child3.childCount - 1 downTo 0) {
                                    val child4 = child3.getChildAt(l)

                                    if (child4 is RadioButton ){
                                        child4.setTextColor(Color.BLACK)
                                    }

                                }
//
                                child3.clearCheck()
                            }

                        }
                    }
                }
            }


        }

    }

    private fun remplissageQuiz(quiz: Quiz) {
        var contenuQuiz:LinearLayout  =  findViewById(R.id.contenu_quiz)

        var compt = 5
        for (i in contenuQuiz.childCount - 1 downTo 0) {
            var child = contenuQuiz.getChildAt(i)

            if (child is LinearLayout){

                for (j in child.childCount - 1 downTo 0) {
                    val child2 = child.getChildAt(j)

                    if(child2 is TextView){
                        var value= quiz.question[i].question.toString()
                        child2.text = "$compt : $value"
                        compt --
                    }

                    if (child2 is LinearLayout){

                        for (k in child2.childCount - 1 downTo 0) {
                            val child3 = child2.getChildAt(k)

                            if (child3 is RadioGroup){

                                for (l in child3.childCount - 1 downTo 0) {
                                    val child4 = child3.getChildAt(l)

                                    if (child4 is RadioButton ){
                                        child4.text = quiz.question[i].answer[l].toString()
                                    }

                                }
                            }

                        }
                    }
                }
            }


        }

    }

    fun Correction(quiz: Quiz) {

        var contenuQuiz:LinearLayout  =  findViewById(R.id.contenu_quiz)

        for (i in contenuQuiz.childCount - 1 downTo 0) {
            var child = contenuQuiz.getChildAt(i)

            if (child is LinearLayout){

                for (j in child.childCount - 1 downTo 0) {
                    val child2 = child.getChildAt(j)

                    if (child2 is LinearLayout){

                        for (k in child2.childCount - 1 downTo 0) {
                            val child3 = child2.getChildAt(k)

                            if (child3 is RadioGroup){

                                for (l in child3.childCount - 1 downTo 0) {
                                    val child4 = child3.getChildAt(l)

                                    if (child4 is RadioButton ){

                                        if (child4 is RadioButton ){
                                            if (child4.isChecked){
                                                child4.setTextColor(Color.RED)
                                            }

                                        }

                                        if (l == quiz.question[i].feedback.toInt()-1){
                                            child4.setTextColor(Color.BLUE)
                                            child4.setChecked(true)
                                        }





                                    }

                                }
                            }

                        }
                    }
                }
            }


        }



    }

    fun Save(quiz: Quiz) {
        var contenuQuiz:LinearLayout  =  findViewById(R.id.contenu_quiz)
        var note  = findViewById<TextView>(R.id.note)


        var compt = 0
        for (i in contenuQuiz.childCount - 1 downTo 0) {
            var child = contenuQuiz.getChildAt(i)

            if (child is LinearLayout){

                for (j in child.childCount - 1 downTo 0) {
                    val child2 = child.getChildAt(j)

                    if (child2 is LinearLayout){

                        for (k in child2.childCount - 1 downTo 0) {
                            val child3 = child2.getChildAt(k)

                            if (child3 is RadioGroup){

                                for (l in child3.childCount - 1 downTo 0) {
                                    val child4 = child3.getChildAt(l)

                                    if (child4 is RadioButton ){
                                        if (child4.isChecked){
                                            compt++
                                        }

                                    }

                                }
                            }

                        }
                    }
                }
            }


        }

        if (compt == 5){
            var moy :Int =0
            findViewById<LinearLayout>(R.id.blocknote).visibility =View.VISIBLE
            findViewById<Button>(R.id.save).isEnabled = false

            for (i in contenuQuiz.childCount - 1 downTo 0) {
                var child = contenuQuiz.getChildAt(i)

                if (child is LinearLayout){

                    for (j in child.childCount - 1 downTo 0) {
                        val child2 = child.getChildAt(j)

                        if (child2 is LinearLayout){

                            for (k in child2.childCount - 1 downTo 0) {
                                val child3 = child2.getChildAt(k)

                                if (child3 is RadioGroup){

                                    for (l in child3.childCount - 1 downTo 0) {
                                        val child4 = child3.getChildAt(l)

                                        if (child4 is RadioButton ){
                                            if (child4.isChecked){
                                                if (l == quiz.question[i].feedback.toInt()-1){
                                                    moy ++
                                                }
                                            }

                                        }

                                    }
                                }

                            }
                        }
                    }
                }


            }

            if (moy <3 ){
                note.text = "NOTE: $moy/5 NIVEAU FAIBLE BIEN RELIRE LE COURS SVP"
                note.setTextColor(R.color.Violet_clair_exr)
            }else if (moy ==3 || moy ==4){
                note.text = "NOTE: $moy/5 BIEN"
                note.setTextColor(R.color.vert_menthe_fort)

            }else{
                note.setTextColor(R.color.vert_menthe_fort)
                note.text = "NOTE: $moy/5 BRAVO !!!"

            }
        }else{
            Toast.makeText(this, "il reste encore Des questions non traitées", Toast.LENGTH_LONG).show()
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
                startActivity(Intent(this,Quiz::class.java))
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


fun previous(
    view: View,
    textPrev: TextView,
    textNext: TextView,
    itenLecon: TextView,
    containCourse: Array<String>,
    pointer: TextView,
    contain: Int
) {
    if ( contain == 0 ){
        textNext.text = "1"
        textPrev.text = " "
        itenLecon.text = containCourse[0]
        pointer.text = "0"
//        Toast.makeText(this, "fin", Toast.LENGTH_SHORT).show()

    }else{
        textNext.text = ((contain+1).toString())
        textPrev.text = ((contain -1).toString())
        itenLecon.text = containCourse[contain]
        pointer.text = ((contain).toString())

    }
}


fun next(
    view: View,
    textPrev: TextView,
    textNext: TextView,
    itenLecon: TextView,
    containCourse: Array<String>,
    pointer: TextView,
    contain: Int, ) {

    if (contain >= containCourse.size - 1 ){
        textNext.text =" "
        textPrev.text = ((contain-1).toString())
        itenLecon.text = containCourse[containCourse.size -1]
        pointer.text = (containCourse.size -1 ).toString()
//        Toast.makeText(null, "fin", Toast.LENGTH_SHORT).show()
    }else{
        textNext.text = ((contain +1).toString())
        textPrev.text = ((contain-1).toString())
        itenLecon.text = containCourse[contain]
        pointer.text = ((contain).toString())
    }

}