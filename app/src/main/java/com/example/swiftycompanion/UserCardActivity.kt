package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

var userData: MutableLiveData< Map<String, *> >? = null

class UserCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_card)
        val textView = findViewById<TextView>(R.id.userDataText)

        val model: UserViewModel by viewModels()
        model.getUser().observe(this, Observer<Map<String, *>> { user ->
            textView.text = user.toString()
        })

    }

}