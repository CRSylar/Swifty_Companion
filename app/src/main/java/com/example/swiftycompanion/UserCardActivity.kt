package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.swiftycompanion.adapter.TabAdapter
import com.example.swiftycompanion.data.UserInfo
import com.example.swiftycompanion.databinding.ActivityUserCardBinding
import com.google.android.material.tabs.TabLayout

var g_userData: UserInfo? = null
var listen = MutableLiveData<Boolean>(false)

class UserCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        viewPager.adapter = TabAdapter(this, supportFragmentManager, lifecycle)

        binding.tabLayout.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
        })

        listen.observe(this, {
            if (listen.value == true) {
                if (g_userData == null) {
                    Toast.makeText(this, "User Not Found!", Toast.LENGTH_LONG).show()
                    finish()
                }
                else {
                    Glide
                        .with(this)
                        .load(g_userData?.imageUrl)
                        .into(binding.proPic)
                    binding.fullName.text = g_userData?.usualFullName

                    binding.wallet.text = ("Wallet: ${g_userData?.wallet.toString()}")
                    binding.evaluationPoint.text = ("Eval.Points: ${g_userData?.correctionPoint.toString()}")
                    binding.level.text = ("Level: ${g_userData?.cursusUsers?.get(1)?.level?.toInt().toString()}")
                    binding.progressHorizontal.progress = calcProgessionLevel()
                    binding.idIntra.text = g_userData?.login
                }
            }
        })
    }


    private fun calcProgessionLevel(): Int {
        val levelDb = g_userData?.cursusUsers?.get(1)?.level

        if (levelDb != null) {
            return ((levelDb - levelDb.toInt()) * 100).toInt()
        }
        return 0
    }
}