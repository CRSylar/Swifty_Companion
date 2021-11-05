package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONObject

var g_userData: Map<String, *> ? = null

class UserCardActivity : AppCompatActivity() {

    private lateinit var tokenManager: OauthTokenManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_card)

        val textView = findViewById<TextView>(R.id.userDataText)

        textView.text = g_userData.toString()
    }
}