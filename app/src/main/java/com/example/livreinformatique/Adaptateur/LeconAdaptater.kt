package com.example.livreinformatique.Adaptateur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livreinformatique.Quiz
import com.example.livreinformatique.R


data class Lecons(val image : Int , val lecon :String , val textLecon : String) {}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // récupérez l'élément sur lequel l'utilisateur a cliqué
        val clickedItem = adapterPosition
    }
}

class LeconAdaptater(private val userData: List<Lecons>) :
    RecyclerView.Adapter<LeconAdaptater.ViewHolder>() {

//    --------------------------------- ecouteur -----------------------------

    private var listener: Quiz.MyItemClickListener? = null

    fun setOnItemClickListener(listener: Quiz.MyItemClickListener) {
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
        val lecon1 : TextView  = itenView.findViewById(R.id.lecon_iten)
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
