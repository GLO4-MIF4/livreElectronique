package com.example.livreinformatique

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.livreinformatique.Adaptateur.LeconAdaptater
import com.example.livreinformatique.Adaptateur.Lecons
import com.example.livreinformatique.animation.ZoomOutPageTransformer
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setContentView(R.layout.activity_cours)

//        var list : RecyclerView = findViewById(R.id.chapitre1)
//
//        val res : Resources = resources
//        val leconsChpa1 : Array<String> = res.getStringArray(R.array.chap1)
//        val listData = arrayListOf<Lecons>()
//        for ( i in leconsChpa1.indices){
//            listData.add(Lecons(leconsChpa1[i]))
//        }

//        var listAdaptateur = LeconAdaptater(listData)
//        list.adapter = listAdaptateur
//        list.layoutManager = LinearLayoutManager(this)


        val viewpager : ViewPager = findViewById(R.id.viewpager)
        val tableLayout : TabLayout = findViewById(R.id.tabLayout)
        tableLayout.setupWithViewPager(viewpager)

        val fragments = listOf(
            ModelFragment(R.layout.screen_main),
            ModelFragment(R.layout.activity_cours),
            ModelFragment(R.layout.screen_main),
            ModelFragment(R.layout.screen_main)
        )

        val ListFragmentAdapter = MyPagerAdapter(supportFragmentManager,fragments)
        viewpager.adapter = ListFragmentAdapter
        viewpager.setPageTransformer(false,ZoomOutPageTransformer())
    }
}