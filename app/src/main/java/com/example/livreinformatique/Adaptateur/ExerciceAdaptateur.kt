package com.example.livreinformatique.Adaptateur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livreinformatique.Exercices
import com.example.livreinformatique.R


class ExerciceAdaptateur (private val userData: List<Lecons>) :
    RecyclerView.Adapter<ExerciceAdaptateur.ViewHolder>() {

//    --------------------------------- ecouteur -----------------------------

    private var listener: Exercices.MyItemClickListener? = null

    fun setOnItemClickListener(listener: Exercices.MyItemClickListener) {
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.iten_quiz,parent ,false)
        return  ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userData[position])
    }


    override fun getItemCount(): Int {
        return  userData.size
    }

    inner class ViewHolder (itenView : View) : RecyclerView.ViewHolder(itenView) ,View.OnClickListener{


        val image1 : ImageView = itenView.findViewById(R.id.image)
        val lecon1 : TextView = itenView.findViewById(R.id.lecon_iten)
        val lecon_text1  : TextView = itenView.findViewById(R.id.textLecon)
        fun bind(userData : Lecons){
            lecon1.text = userData.lecon
            lecon_text1.text = userData.textLecon
            image1.setImageResource(userData.image)
        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener?.onItemClick(adapterPosition)
        }

//        override fun onClick(v: View?) {
//            val position = adapterPosition
//            Toast.makeText(v?.context, "Element $position cliqué", Toast.LENGTH_SHORT).show()
//        }

    }
}
