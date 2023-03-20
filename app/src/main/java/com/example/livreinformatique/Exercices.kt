package com.example.livreinformatique

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livreinformatique.Adaptateur.ExerciceAdaptateur
import com.example.livreinformatique.Adaptateur.LeconAdaptater
import com.example.livreinformatique.Adaptateur.Lecons
import com.example.livreinformatique.iten.itemExercices
import com.example.livreinformatique.iten.iten_quiz

class Exercices : AppCompatActivity() {

    private lateinit var quiz_list: List<Lecons>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercices)


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




        val res : Resources = resources
        val quizs : Array<String> = res.getStringArray(R.array.lecons)

        val quiz_list = listOf(
            Lecons(R.drawable.exercice,"", quizs[0]),
            Lecons(R.drawable.exercice,"", quizs[1]),
            Lecons(R.drawable.exercice,"", quizs[2]),
            Lecons(R.drawable.exercice,"", quizs[3]),
            Lecons(R.drawable.exercice,"", quizs[4]),
            Lecons(R.drawable.exercice,"", quizs[5]),
            Lecons(R.drawable.exerciceone,"", quizs[6]),

            Lecons(R.drawable.exerciceone,"", quizs[7]),
            Lecons(R.drawable.exerciceone,"", quizs[8]),
            Lecons(R.drawable.exerciceone,"", quizs[9]),
            Lecons(R.drawable.exerciceone,"", quizs[10]),
            Lecons(R.drawable.exerciceone,"", quizs[11]),
            Lecons(R.drawable.exercicestrois,"", quizs[12]),

            Lecons(R.drawable.exercicestrois,"", quizs[13]),
            Lecons(R.drawable.exercicestrois,"", quizs[14]),
            Lecons(R.drawable.exercicestrois,"", quizs[15]),
            Lecons(R.drawable.exercicestrois,"", quizs[16]),
            Lecons(R.drawable.exercicestrois,"", quizs[17]),
            Lecons(R.drawable.exercicestrois,"", quizs[18]),

            Lecons(R.drawable.exercice,"", quizs[19]),
            Lecons(R.drawable.exercicestrois,"", quizs[20]),
            Lecons(R.drawable.exercice,"", quizs[21]),
            Lecons(R.drawable.exercice,"", quizs[22]),
            Lecons(R.drawable.exercice,"", quizs[23]),
            Lecons(R.drawable.exercice,"", quizs[24]),
        )
        val recyclerView =  findViewById<RecyclerView>(R.id.RecycleExercices)

        val adapter = ExerciceAdaptateur(quiz_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val myItemClickListener = MyItemClickListener()
        adapter.setOnItemClickListener(myItemClickListener)
    }
    inner class  MyItemClickListener {
        fun onItemClick(position: Int) {
            val intent = Intent(this@Exercices, itemExercices::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}