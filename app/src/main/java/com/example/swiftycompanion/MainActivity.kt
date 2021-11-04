package com.example.swiftycompanion

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import org.json.JSONObject

/* Example of a Token
data class Token(
    val access_token : String,
    val token_type: String,
    val expires_in: String,
    val scope: String,
    val created_at: String
)
*/

class MainActivity : AppCompatActivity() {

    private lateinit var tokenManager: OauthTokenManager
    private lateinit var sharedPreferences: SharedPreferences
    private var token : Map<String, *>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tokenManager = OauthTokenManager(this)
        val userName = findViewById<TextInputEditText>(R.id.searc_box)
        val btn = findViewById<Button>(R.id.callApiBtn)
        sharedPreferences = getSharedPreferences("42token",MODE_PRIVATE)

        btn.setOnClickListener { toNewActivity(userName.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        val json = sharedPreferences.getString("42token", "")
        while (token == null)
            token =
                if (json.isNullOrEmpty())
                    tokenManager.getToken()
                else
                    JSONObject(json).toMap()
    }

    override fun onStop() {
        super.onStop()
        val gson = Gson().toJson(token)
        sharedPreferences.edit().putString("42token", gson).apply()
    }

    private fun toNewActivity(userName: String) {
        if (userName.isEmpty())
            return

        val userData = UserData(tokenManager.showRes(userName, token?.get("access_token") as String))
        val intent = Intent(this, UserCardActivity:: class.java)

        intent.putExtra("userData", userData)
    }
}
