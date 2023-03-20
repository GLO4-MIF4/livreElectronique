package com.example.login
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livreinformatique.R

class CourseRVAdapter (
    // on below line we are passing variables as course list and context
    private var courseList: ArrayList<CourseRVModal>,
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseRVAdapter.CourseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.course_rv_item,
            parent, false
        )

        // at last we are returning our view holder
        // class with our item View File.
        return CourseViewHolder(itemView)
    }

    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<CourseRVModal>) {
        // below line is to add our filtered
        // list in our course array list.
        courseList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.courseIV.text = courseList.get(position).courseImg
        holder.courseNameTV.text = courseList.get(position).courseName
        holder.Img.setImageResource(courseList.get(position).Img)


    }

    override fun getItemCount(): Int {
        // on below line we are returning
        // our size of our list
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val courseIV: TextView = itemView.findViewById(R.id.idIVCourse)
        val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
        val Img:ImageView=itemView.findViewById(R.id.idImg)


    }
}