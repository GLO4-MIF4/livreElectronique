package com.example.livreinformatique.iten

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.livreinformatique.*
import org.xmlpull.v1.XmlPullParser

class Lecon(
    var titre: MutableList<Sous_titre>,
    var sous_titre: MutableList<Sous_titre>, )
class Sous_titre (var titre:String ,
                  var paragraphe : MutableList<String>)

class item_courts : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iten_cours)



//-----------------------------------------------------------------------------------------------------


        val Lecons = mutableListOf<Lecon>()
// Variables pour stocker les informations de chaque livre

        var paragraphe1= mutableListOf<String>()
        var paragraphe2 = mutableListOf<String>()
        var valTitre : String? = null
        var valSousTitre : String? = null
        var titre = mutableListOf<Sous_titre>()
        var sous_titre = mutableListOf<Sous_titre>()
        var parser = resources.getXml(R.xml.cours)

        var swap :Int = 1
        var passe :Int = 1
        var initTitre: Int = 0

// Boucle pour parcourir le fichier XML et extraire les informations de chaque livre

        while (parser.eventType != XmlPullParser.END_DOCUMENT) {
            passe = 2
            when (parser.eventType) {
                XmlPullParser.START_TAG -> {
                    when (parser.name) {
                        "titre" ->{
                            valTitre = parser.nextText()
                            passe = 0
                            initTitre =1
                            swap =1
                        }
                        "paragraphe" ->{
                            passe = 0

                            if (swap == 1){
                                paragraphe1.add(parser.nextText())
                            }else{
                                var values = parser.nextText()
                                paragraphe2.add(values)
                            }

                        }
                        "sous-titre" -> {
                            passe = 0

                            if (paragraphe2.size != 0){
                                var instance2  = valSousTitre?.let { Sous_titre(it,paragraphe2) }

                                if (instance2 != null) {
                                    sous_titre.add(instance2)
                                }
                                paragraphe2 = mutableListOf<String>()
                            }
                            valSousTitre = parser.nextText()
                            swap = 2
                        }
                    }
                }
                XmlPullParser.END_TAG -> {
                    if (parser.name == "lecon") {
                        // Fin du livre, ajouter un nouvel objet Book à la liste

                        var instance1  = valTitre?.let { Sous_titre(it,paragraphe1) }
                        if (instance1 != null) {
                            titre.add(instance1)
                        }
                        paragraphe1 = mutableListOf<String>()

                        var instance2  = valSousTitre?.let { Sous_titre(it,paragraphe2) }

                        if (instance2 != null) {
                            sous_titre.add(instance2)
                        }
                        paragraphe2 = mutableListOf<String>()

                        Lecons.add(Lecon(titre,sous_titre))
                        titre = mutableListOf<Sous_titre>()
                        sous_titre =mutableListOf<Sous_titre>()
                    }
                }
            }
            if(passe != 0){
                parser.next()
            }

        }
        Lecons

//--------------------------------------------------------------------------------------------------






        val res : Resources = resources
        val  containCourse : Array<String> = res.getStringArray(R.array.lecons)

        val prev : ImageButton = findViewById(R.id.previuosC)
        val next : ImageButton = findViewById(R.id.nextC)
        val textPrev = findViewById<TextView>(R.id.textPrevC)
        val textNext = findViewById<TextView>(R.id.textNextC)
        val pointer = findViewById<TextView>(R.id.pointerLeconC)

        val itenLecon = findViewById<TextView>(R.id.itenLecon1C)

        var position = intent.getIntExtra( "position",0)
        var parentRecycleViewNumber = intent.getIntExtra( "pointer",0)

//            ...............................................................??
        remplissageCour(Lecons[position + parentRecycleViewNumber ])
//            ..................................................................?

        if (position + parentRecycleViewNumber  == 0){
            previous(prev, textPrev, textNext, itenLecon, containCourse, pointer, 0)
        }else if(position + parentRecycleViewNumber  == containCourse.size -1){
            next(prev, textPrev, textNext, itenLecon, containCourse, pointer, containCourse.size-1)
        }else{
            previous(prev, textPrev, textNext, itenLecon, containCourse, pointer, position + parentRecycleViewNumber)
        }

        next.setOnClickListener(View.OnClickListener {
            nextC(next,textPrev,textNext,itenLecon, containCourse,pointer,Lecons )

        })
        prev.setOnClickListener(View.OnClickListener {
            previousC(prev,textPrev,textNext,itenLecon, containCourse,pointer,Lecons)
        })


        var quizz :Button = findViewById(R.id.iten_quizCour)
        quizz.setOnClickListener(View.OnClickListener {
           submitQQ(this)
        })

        var exerceices : Button  = findViewById(R.id.iten_exerciceCour)
        exerceices.setOnClickListener(View.OnClickListener {
          submitEE(this)
        })



    }

    fun previousC(
        view: View,
        textPrev: TextView,
        textNext: TextView,
        itenLecon: TextView,
        containCourse: Array<String>,
        pointer: TextView,
        Lecons: MutableList<Lecon>
    ) {

        var contain: Int
        if (textPrev.text == " "){
            contain  = 0
        }else{
            contain = Integer.parseInt(textPrev.text as String)
        }

        remplissageCour(Lecons[contain])

        if ( contain == 0 ){
            textNext.text = "1"
            textPrev.text = " "
            itenLecon.text = containCourse[0]
            pointer.text = "0"
            Toast.makeText(this, "fin", Toast.LENGTH_SHORT).show()
        }else{
            textNext.text = ((contain+1).toString())
            textPrev.text = ((contain-1).toString())
            itenLecon.text = containCourse[contain]
            pointer.text = ((contain).toString())

        }
    }


    fun nextC(
        view: View,
        textPrev: TextView,
        textNext: TextView,
        itenLecon: TextView,
        containCourse: Array<String>,
        pointer: TextView,
        Lecons: MutableList<Lecon>, ) {

        var contain: Int

        if (textNext.text == "  "){
            contain  = containCourse.size -1
        }else{
            contain = Integer.parseInt(textNext.text as String)
        }
        remplissageCour(Lecons[contain])

        if (contain == containCourse.size -1 ){
            textNext.text ="  "
            textPrev.text = ((contain-1).toString())
            itenLecon.text = containCourse[containCourse.size -1]
            pointer.text = (containCourse.size -1 ).toString()
            Toast.makeText(this, "fin", Toast.LENGTH_SHORT).show()
        }else{
            textNext.text = ((contain +1).toString())
            textPrev.text = ((contain-1).toString())
            itenLecon.text = containCourse[contain]
            pointer.text = ((contain).toString())
        }
    }

    fun submitEE(view: item_courts) {

        var position  = findViewById<TextView>(R.id.textPrevC).text
        var position2:Int
        if (position == " "){ position2 = 0 }
        else{position2 = Integer.parseInt(position as String) +1 }

        var intent = Intent(this,itemExercices::class.java)
        intent.putExtra("position",position2)
        startActivity(intent)
    }
    fun submitQQ(view: item_courts) {

        var position  = findViewById<TextView>(R.id.textPrevC).text
        var position2:Int
        if (position == " "){ position2 = 1 }
        else{position2 = Integer.parseInt(position as String) +1}

        var intent = Intent(this,iten_quiz::class.java)
        intent.putExtra("position",position2)
        startActivity(intent)

    }

    fun remplissageCour(lecon: Lecon) {

        var linearLayout :LinearLayout = findViewById(R.id.contenu_cours)
//        var titre : TextView =findViewById(R.id.titre)


        for (i in linearLayout.childCount - 1 downTo 0) {
            val child = linearLayout.getChildAt(i)
            linearLayout.removeView(child)
        }


        lecon.titre.forEach {
            it.paragraphe.forEach {

                var soustitre = TextView(this)
                soustitre.text = it
                soustitre.textSize =20F
                soustitre.typeface = Typeface.create("serif-monospace", Typeface.NORMAL)
                soustitre.setPadding(5, 5, 5,10)
                linearLayout.addView(soustitre)
            }
        }

var comt :Int  = 1
        lecon.sous_titre.forEach {
            var soustitre = TextView(this)
            var tit =  it.titre
            soustitre.text = " $comt : $tit"
            soustitre.textSize =25F
            soustitre.typeface = Typeface.create("serif-monospace", Typeface.NORMAL)
            soustitre.setPadding(5, 5, 5, 5)
            soustitre.setTypeface(null, Typeface.BOLD)

            var parent = LinearLayout(this)
            val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_corners_background)
            parent.background = drawable
            parent.addView(soustitre)
            linearLayout.addView(parent)

            comt ++
            it.paragraphe.forEach {
                var soustitre = TextView(this)
                soustitre.text = it
                soustitre.textSize =20F
                soustitre.typeface = Typeface.create("serif-monospace", Typeface.NORMAL)
                soustitre.setPadding(5, 5, 5,5)
                linearLayout.addView(soustitre)
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

