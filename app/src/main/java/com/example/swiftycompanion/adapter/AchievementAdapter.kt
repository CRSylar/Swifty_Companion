package com.example.swiftycompanion.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.decode.SvgDecoder
import coil.request.ImageRequest
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

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        val item = g_userData?.achievements?.groupBy { it.name }?.map { it.value.last() }
        if (item != null){
            val tmp = item[position]
            holder.name.text = tmp.name
            holder.subTitle.text = tmp.description
            holder.img.loadUrl("$intraUrl${tmp.image}")
//            Glide
//                .with(holder.view.context)
//                .load("$intraUrl${tmp.image}")
//                .into(holder.img)
            holder.backgroud.background =
                when(tmp.tier) {
                    "easy" -> holder.view.context.resources.getDrawable(R.drawable.border_bronze, null)
                    "medium" -> holder.view.context.resources.getDrawable(R.drawable.border_silver, null)
                    "hard" -> holder.view.context.resources.getDrawable(R.drawable.border_gold, null)
                else -> holder.view.context.resources.getDrawable(R.drawable.border_white, null)
            }
        }
    }

    override fun getItemCount(): Int {
        val item = g_userData?.achievements?.groupBy { it.name }?.map { it.value.last() }
        return item?.size ?: 0
    }

}

private fun ImageView.loadUrl(url: String) {

    val imageLoader = coil.ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadUrl.context)) }
        .build()

    val req = ImageRequest.Builder(this.context)
        .crossfade(true)
        .crossfade(500)
        .data(url)
        .target(this)
        .build()

    imageLoader.enqueue(req)
}
