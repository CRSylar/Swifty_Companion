package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.json.JSONObject

var g_userData: Map<String, *> ? = null
var listen = MutableLiveData<Boolean>(false)

class UserCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_card)

        val textView = findViewById<TextView>(R.id.userDataText)
        listen.observe(this, Observer {
            if (listen.value == true) {
                if (g_userData == null)
                {
                    Toast.makeText(this, "User Not Found!", Toast.LENGTH_LONG).show()
                    finish()
                }
                textView.text = g_userData.toString()
            }
        })
    }
}