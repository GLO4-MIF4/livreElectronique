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
import com.example.livreinformatique.Adaptateur.LeconAdaptater
import com.example.livreinformatique.Adaptateur.Lecons
import com.example.livreinformatique.iten.iten_quiz

class Quiz : AppCompatActivity() {
    private lateinit var quiz_list: List<Lecons>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


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
            Lecons(R.drawable.quizone,"", quizs[0]),
            Lecons(R.drawable.quizone,"", quizs[1]),
            Lecons(R.drawable.quizone,"", quizs[2]),
            Lecons(R.drawable.quizone,"", quizs[3]),
            Lecons(R.drawable.quizone,"", quizs[4]),
            Lecons(R.drawable.quizone,"", quizs[5]),
            Lecons(R.drawable.quizone,"", quizs[6]),

            Lecons(R.drawable.quizdeux,"", quizs[7]),
            Lecons(R.drawable.quizdeux,"", quizs[8]),
            Lecons(R.drawable.quizdeux,"", quizs[9]),
            Lecons(R.drawable.quizdeux,"", quizs[10]),
            Lecons(R.drawable.quizdeux,"", quizs[11]),
            Lecons(R.drawable.quizdeux,"", quizs[12]),

            Lecons(R.drawable.quiztois,"", quizs[13]),
            Lecons(R.drawable.quiztois,"", quizs[14]),
            Lecons(R.drawable.quiztois,"", quizs[15]),
            Lecons(R.drawable.quiztois,"", quizs[16]),
            Lecons(R.drawable.quiztois,"", quizs[17]),
            Lecons(R.drawable.quiztois,"", quizs[18]),

            Lecons(R.drawable.quizquatre,"", quizs[19]),
            Lecons(R.drawable.quizquatre,"", quizs[20]),
            Lecons(R.drawable.quizquatre,"", quizs[21]),
            Lecons(R.drawable.quizquatre,"", quizs[22]),
            Lecons(R.drawable.quizquatre,"", quizs[23]),
            Lecons(R.drawable.quizquatre,"", quizs[24]),
        )
        val recyclerView =  findViewById<RecyclerView>(R.id.RecycleQuiz)

        val adapter = LeconAdaptater(quiz_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val myItemClickListener = MyItemClickListener()
        adapter.setOnItemClickListener(myItemClickListener)

    }

    inner class  MyItemClickListener {
        fun onItemClick(position: Int) {
            val intent = Intent(this@Quiz, iten_quiz::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}

//interface MyItemClickListener {
//    fun onItemClick(position: Int)
//}

//class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
//    fun bind(planet: Planet) {
//        itemView.planetName.text = planet.name
//        itemView.planetImage.setImageResource(planet.image)
//        itemView.setOnClickListener(this)
//    }
//    override fun onClick(v: View?) {
//        val position = adapterPosition
//        Toast.makeText(v?.context, "Element $position cliqué", Toast.LENGTH_SHORT).show()
//
//    }