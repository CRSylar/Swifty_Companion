package com.example.swiftycompanion.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftycompanion.CURSUS
import com.example.swiftycompanion.R
import com.example.swiftycompanion.g_userData

class ProjectAdapter() : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    class ProjectViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById<TextView>(R.id.title)
        val vote: TextView = view.findViewById<TextView>(R.id.vote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_project, parent, false)

        return ProjectViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val item = if (CURSUS == 1)
            g_userData?.projectsUsers?.filter { !it.project.slug.startsWith("c-piscine") }
        else
            g_userData?.projectsUsers?.filter { it.project.slug.startsWith("c-piscine") }
        if (item != null) {
            val temp = item[position]
            holder.title.text = temp.project.name
            if (temp.status == "finished") {
                if (temp.validated == false)
                    holder.vote.setTextColor(Color.RED)
                else
                    holder.vote.setTextColor(Color.GREEN)
                holder.vote.text = temp.finalMark.toString()
            }
            else
            {
                holder.vote.setTextColor(Color.GRAY)
                holder.vote.text = holder.view.context.getString(R.string.projectOnGoing)
            }
        }
    }


    override fun getItemCount(): Int {
        val item = if (CURSUS == 1)
            g_userData?.projectsUsers?.filter { !it.project.slug.startsWith("c-piscine") }
        else
            g_userData?.projectsUsers?.filter { it.project.slug.startsWith("c-piscine") }
        return item?.size ?: 0
    }
}