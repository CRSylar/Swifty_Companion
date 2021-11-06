package com.example.swiftycompanion

import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.swiftycompanion.databinding.ActivityUserCardBinding
import org.json.JSONObject

var g_userData: Map<String, *> ? = null
var listen = MutableLiveData<Boolean>(false)

class UserCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listen.observe(this, Observer {
            if (listen.value == true) {
                if (g_userData == null) {
                    Toast.makeText(this, "User Not Found!", Toast.LENGTH_LONG).show()
                    finish()
                }
                Glide
                    .with(this)
                    .load(g_userData!!["image_url"])
                    .into(binding.proPic)
                binding.userDataText.text = g_userData.toString()
            }
        })
    }
}