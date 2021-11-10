package com.example.swiftycompanion.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.swiftycompanion.R
import com.example.swiftycompanion.g_userData
import com.example.swiftycompanion.intraUrl

class AchievementAdapter(): RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>() {

    class AchievementViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById<TextView>(R.id.achievement_name)
        val subTitle: TextView = view.findViewById<TextView>(R.id.achievement_under_name)
        val img : ImageView = view.findViewById<ImageView>(R.id.achievement_img)
        val backgroud: LinearLayout = view.findViewById<LinearLayout>(R.id.achievement_background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_achievements, parent, false)

        return AchievementViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        //val item = g_userData?.achievements?.reversed()?.toSet()?.toList()
        val item = g_userData?.achievements?.groupBy { it.name }?.map { it.value.last() }
        if (item != null){
            val tmp = item[position]
            holder.name.text = tmp.name
            holder.subTitle.text = tmp.description
            Glide
                .with(holder.view.context)
                .load("$intraUrl${tmp.image}")
                .into(holder.img)
            holder.backgroud.setBackgroundColor(
                when(tmp.tier) {
                    "easy" -> Color.rgb(141, 91, 45)
                    "medium" -> Color.rgb(203, 212, 214)
                    "hard" -> Color.rgb(185, 174, 110)
                    else -> Color.WHITE
                }
            )
        }
    }

    override fun getItemCount(): Int {
        //val item = g_userData?.achievements?.reversed()?.toSet()?.toList()
        val item = g_userData?.achievements?.groupBy { it.name }?.map { it.value.last() }
        return item?.size ?: 0
    }

}