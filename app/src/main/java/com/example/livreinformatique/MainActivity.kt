package com.example.livreinformatique

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "WrongViewCast", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cours : Button = findViewById(R.id.cours_main_body)
        var quiz : Button = findViewById(R.id.quiz_main)
        var exercice : Button = findViewById(R.id.exercices_main)
        var jardon : Button = findViewById(R.id.jargon_main)

        cours.setOnClickListener(View.OnClickListener {
           submitC(this)
        })
        quiz.setOnClickListener(View.OnClickListener {
            submitQ(this)
        })
        exercice.setOnClickListener(View.OnClickListener {
            submitE(this)
        })
        jardon.setOnClickListener(View.OnClickListener {
            submitJ(this)
        })


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

        findViewById<Button>(R.id.voirplus).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Cours_update::class.java))
        })


//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//// Créer un ImageView pour le logo
//        val logo = ImageView(this)
//        logo.setImageResource(R.drawable.two)
//
//// Créer un TextView pour le titre
//        val title = TextView(this)
//        title.text = "Titre de l'application"
//        title.textSize = 10f
//        title.setTextColor(ContextCompat.getColor(this, R.color.white))
//
//
//        // Ajouter des éléments de menu
//        toolbar.inflateMenu(R.menu.menu_pricipal)
//
//// Ajouter le logo et le titre à la Toolbar
////        toolbar.addView(logo)
//        toolbar.addView(title)
//
//// Ajouter un bouton de navigation
//        toolbar.setNavigationIcon(R.drawable.left)
//
//// Ajouter des éléments de menu
//        toolbar.inflateMenu(R.menu.menu_pricipal)
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
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun change_color_on_clic(myLinearLayout : View){
        var isClicked = false

        if (isClicked) {
            myLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.vert_menthe_fort))
            isClicked = false
        } else {
            myLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.vert_menthe))
            isClicked = true
        }
    }

    fun submitQ(view: MainActivity) {
        startActivity(Intent(this,Quiz::class.java))
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

    }
    fun submitE(view: MainActivity) {
        startActivity(Intent(this,Exercices::class.java))
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

    }
    fun submitC(view: MainActivity) {
        startActivity(Intent(this,Cours_update::class.java))
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

    fun submitH(view: View) {}
    fun submitJ(view: MainActivity) {
        startActivity(Intent(this,Jargon::class.java))
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

}


//        val viewpager: ViewPager = findViewById(R.id.viewpager)
//        val tableLayout: TabLayout = findViewById(R.id.tabLayout)
//        tableLayout.setupWithViewPager(viewpager)
//
//        val fragments = listOf(
//            ModelFragment(R.layout.activity_main_second),
//            ModelFragment(R.layout.activity_cours),
//            ModelFragment(R.layout.activity_exercices),
//            ModelFragment(R.layout.activity_quiz),
//            ModelFragment(R.layout.activity_jargon),
//            ModelFragment(R.layout.activity_progression)
//        )
//
//        val ListFragmentAdapter = MyPagerAdapter(supportFragmentManager, fragments)
//        viewpager.adapter = ListFragmentAdapter
//        viewpager.setPageTransformer(false, ZoomOutPageTransformer())
