package com.example.livreinformatique

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.livreinformatique.iten.item_courts

class Cours : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cours)

        val res : Resources = resources
        val  containCours : Array<String> = res.getStringArray(R.array.lecons)
//
//        var tab1 :ArrayList<String>
//        tab1 = listOf("") as ArrayList<String>
//
//        var tab2 :ArrayList<String>
//        tab2 = listOf("") as ArrayList<String>
////        divisions des lecons des modules
//
//        var compt = 0
//        containCours.forEach {
//            if (compt <14 ){
//                tab1.add(it)
//            }else{
//                tab2.add(it)
//            }
//        }
//        tab2.removeAt(0)
//        tab1.removeAt(0)
//


        var button : LinearLayout = findViewById(R.id.CrLecon1)
        button.setOnClickListener(View.OnClickListener {
            afficherLecons( containCours[0] )
        })

    }

    fun afficherLecons( string: String) {
        val intent = Intent(this,item_courts::class.java)
        intent.putExtra("Lecons", string)
        startActivity(intent)
    }
}