package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_card)

        val textView = findViewById<TextView>(R.id.userDataText)

        val user = intent?.getSerializableExtra("userData") as UserData

        textView.text = user.data.toString()
    }
}