package com.example.livreinformatique

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livreinformatique.Adaptateur.CoursAdaptateur
import com.example.livreinformatique.Adaptateur.Lecons
import com.example.livreinformatique.iten.item_courts

class Cours_update : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cours_update)


        findViewById<ImageButton>(R.id.homec).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.cours_24c).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Cours_update::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.quiz_24c).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Quiz::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.exercice_24c).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Exercices::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })

        findViewById<ImageButton>(R.id.jargon_24c).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Jargon::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        })



        val res : Resources = resources
        val quizs : Array<String> = res.getStringArray(R.array.lecons)

        val quiz_list = listOf(
            Lecons(R.drawable.coursone,"", quizs[0]),
            Lecons(R.drawable.coursone,"", quizs[1]),
            Lecons(R.drawable.coursdeux,"", quizs[2]),
            Lecons(R.drawable.coursdeux,"", quizs[3]),
            Lecons(R.drawable.courstrois,"", quizs[4]),
            Lecons(R.drawable.courstrois,"", quizs[5]),
            Lecons(R.drawable.courstrois,"", quizs[6]),

            Lecons(R.drawable.courstrois,"", quizs[7]),
            Lecons(R.drawable.coursqutre,"", quizs[8]),
            Lecons(R.drawable.coursqutre,"", quizs[9]),
            Lecons(R.drawable.coursqutre,"", quizs[10]),
            Lecons(R.drawable.coursqutre,"", quizs[11]),
            Lecons(R.drawable.coursqutre,"", quizs[12]),

            Lecons(R.drawable.coursqutre,"", quizs[13]),
        )

        val recyclerView =  findViewById<RecyclerView>(R.id.RecycleCours1)
        val adapter = CoursAdaptateur(quiz_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val quiz_list2 = listOf(
            Lecons(R.drawable.courscinq,"", quizs[14]),
            Lecons(R.drawable.courscinq,"", quizs[15]),
            Lecons(R.drawable.courscinq,"", quizs[16]),
            Lecons(R.drawable.courssix,"", quizs[17]),
            Lecons(R.drawable.courssix,"", quizs[18]),

            Lecons(R.drawable.courssept,"", quizs[19]),
            Lecons(R.drawable.courssept,"", quizs[20]),
            Lecons(R.drawable.courshuit,"", quizs[21]),
            Lecons(R.drawable.courshuit,"", quizs[22]),
            Lecons(R.drawable.courshuit,"", quizs[23]),
            Lecons(R.drawable.courshuit,"", quizs[24]),
        )

        val recyclerView2 =  findViewById<RecyclerView>(R.id.RecycleCours2)
        val adapter2 = CoursAdaptateur(quiz_list2)
        recyclerView2.adapter = adapter2
        recyclerView2.layoutManager = LinearLayoutManager(this)


        val myItemClickListener = MyItemClickListener()
        adapter.setOnItemClickListener(myItemClickListener)
        adapter2.setOnItemClickListener(myItemClickListener)
    }
    inner class  MyItemClickListener {
        fun onItemClick(position: Int, v: ViewParent) {
            val recyclerView =  findViewById<RecyclerView>(R.id.RecycleCours2)
            var positionRecyview :Int = 0

            if (v == recyclerView ){
                positionRecyview = 14
            }
            val intent = Intent(this@Cours_update, item_courts::class.java)
            intent.putExtra("position", position)
            intent.putExtra("pointer",positionRecyview)
            startActivity(intent)
        }
    }
}