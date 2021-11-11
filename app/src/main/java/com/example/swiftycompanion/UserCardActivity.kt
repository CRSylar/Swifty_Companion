package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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
    private lateinit var mTabLayout: TabLayout.OnTabSelectedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserCardBinding.inflate(layoutInflater)
        listen.observe(this, {
            if (listen.value == true) {
                if (g_userData == null) {
                    Toast.makeText(this, "User Not Found!", Toast.LENGTH_LONG).show()
                    finish()
                }
                else {
                    if (CURSUS == 1)
                        displayCursus()
                    else
                        displayPiscine()
                }
            }
        })
        
        setContentView(binding.root)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPager = binding.viewPager
        viewPager.adapter = TabAdapter(this, supportFragmentManager, lifecycle)
        mTabLayout = object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
        }
        binding.tabLayout.addOnTabSelectedListener(mTabLayout)
    }

    override fun onStop() {
        super.onStop()

        binding.tabLayout.removeOnTabSelectedListener(mTabLayout)
        g_userData = null
        listen.value = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()

        return super.onOptionsItemSelected(item)
    }

    private fun displayPiscine() {
        Glide
            .with(this)
            .load(g_userData?.imageUrl)
            .into(binding.proPic)
        binding.fullName.text = g_userData?.usualFullName

        binding.wallet.text = ("Wallet: ${g_userData?.wallet.toString()}")
        binding.evaluationPoint.text = ("Eval.Points: ${g_userData?.correctionPoint.toString()}")
        binding.level.text = ("Level: ${g_userData?.cursusUsers?.get(0)?.level?.toInt().toString()}")
        binding.progressHorizontal.progress = calcProgessionLevel()
        binding.idIntra.text = g_userData?.login
    }

    private fun displayCursus() {
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


    private fun calcProgessionLevel(): Int {
        val levelDb =
            if (CURSUS == 1)
                g_userData?.cursusUsers?.get(1)?.level
            else
                g_userData?.cursusUsers?.get(0)?.level

        if (levelDb != null) {
            return ((levelDb - levelDb.toInt()) * 100).toInt()
        }
        return 0
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when(view.id) {
                R.id.radio_cursus -> if (checked){
                    CURSUS = 1
                    listen.value = true
                }
                R.id.radio_piscine -> if (checked){
                    CURSUS = 0
                    listen.value = true
                }
            }
        }
    }
}