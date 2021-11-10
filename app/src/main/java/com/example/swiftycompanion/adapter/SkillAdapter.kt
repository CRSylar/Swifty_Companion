package com.example.swiftycompanion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftycompanion.CURSUS
import com.example.swiftycompanion.R
import com.example.swiftycompanion.data.Skill
import com.example.swiftycompanion.g_userData

class SkillAdapter() : RecyclerView.Adapter<SkillAdapter.SkillViewHolder>() {

    class SkillViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById<TextView>(R.id.skill_name)
        val value: ProgressBar = view.findViewById<ProgressBar>(R.id.skill_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_skill, parent, false)

        return SkillViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val item: List<Skill>? = if (CURSUS == 1)
            g_userData?.cursusUsers?.get(1)?.skills
        else
            g_userData?.cursusUsers?.get(0)?.skills

        if (item != null) {
            val temp = item[position]
            holder.name.text = temp.name
            holder.value.progress = temp.level.toInt()
        }
    }

    override fun getItemCount(): Int {
        val item: List<Skill>? = if (CURSUS == 1)
            g_userData?.cursusUsers?.get(1)?.skills
        else
            g_userData?.cursusUsers?.get(0)?.skills
        return item?.size ?: 0
    }
}