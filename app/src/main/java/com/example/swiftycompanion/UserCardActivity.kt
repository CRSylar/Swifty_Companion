package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.swiftycompanion.data.UserInfo
import com.example.swiftycompanion.databinding.ActivityUserCardBinding

var g_userData: UserInfo? = null
var listen = MutableLiveData<Boolean>(false)

class UserCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                }
            }
        })
    }
}