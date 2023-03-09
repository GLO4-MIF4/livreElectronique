package com.example.livreinformatique.Adaptateur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livreinformatique.R


data class Lecons(val titre :String){}

class LeconAdaptater (private val userData : List<Lecons>) :
    RecyclerView.Adapter<LeconAdaptater.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_slide_cours,parent ,false)
        return  ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userData[position])
    }


    override fun getItemCount(): Int {
        return  userData.size
    }
    class ViewHolder (itenView : View) : RecyclerView.ViewHolder(itenView){

        val Titre : TextView = itenView.findViewById(R.id.lecon)

        fun bind(userData : Lecons){
            Titre.text = userData.titre
        }
    }

}