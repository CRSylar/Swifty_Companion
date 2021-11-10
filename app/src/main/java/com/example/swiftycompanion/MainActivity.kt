package com.example.swiftycompanion

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.util.*

class MainActivity : AppCompatActivity(){

    private lateinit var tokenManager: OauthTokenManager
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<TextInputEditText>(R.id.searc_box)
        val btn = findViewById<Button>(R.id.callApiBtn)
        tokenManager = OauthTokenManager(this)
        sharedPreferences = getSharedPreferences("42token",MODE_PRIVATE)

        userName.setOnKeyListener(View.OnKeyListener{_, keycode, event ->
            if (keycode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN){
                val kboard = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                kboard.hideSoftInputFromWindow(View(this).windowToken, 0)
                btn.performClick()
                return@OnKeyListener true
            }
            false
        })
        btn.setOnClickListener { toNewActivity(userName.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        val json = sharedPreferences.getString("42token", "")
        if (json.isNullOrEmpty()){
            tokenManager.getToken()
        }
        else
            tokenManager.checkToken()
    }

    override fun onStop() {
        super.onStop()
        val gson = Gson().toJson(tokenManager.token)
        sharedPreferences.edit().putString("42token", gson).apply()
    }

    private fun toNewActivity(userName: String) {
        if (userName.isEmpty() || tokenManager.token == null)
            return

        tokenManager.showRes(userName)

        val intent = Intent(this@MainActivity, UserCardActivity:: class.java)
        startActivity(intent)
    }
}
