package com.example.swiftycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftycompanion.adapter.ProjectAdapter
import com.example.swiftycompanion.adapter.SkillAdapter


class SkillFragment : Fragment() {
    private var adapter: RecyclerView.Adapter<SkillAdapter.SkillViewHolder>? = null
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onResume() {
        super.onResume()

        recyclerView = requireView().findViewById<RecyclerView>(R.id.skill_rec_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = SkillAdapter()
    }

    override fun onPause() {
        super.onPause()
        recyclerView.adapter = null
    }
}