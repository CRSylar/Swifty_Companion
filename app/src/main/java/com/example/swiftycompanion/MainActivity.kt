package com.example.swiftycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.AuthFailureError
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

data class Token(
    val access_token : String,
    val token_type: String,
    val expires_in: String,
    val scope: String,
    val created_at: String
)

class MainActivity : AppCompatActivity() {

    private lateinit var token : Map<String, *>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.callApiBtn)
        val textView = findViewById<TextView>(R.id.textView)
        val test = findViewById<Button>(R.id.test)
        val res = findViewById<TextView>(R.id.response)
        btn.setOnClickListener { getToken(textView) }
        test.setOnClickListener { showRes(textView, res) }
    }

    private fun showRes(textView: TextView?, res: TextView?) {
        textView?.text = ""
        res?.text = ""

        val url = "https://api.intra.42.fr/v2/users/cromalde"

        val args = "${token["token_type"]} ${token["access_token"]}"

        val req = object : JsonObjectRequest(Request.Method.GET,
            "$url",
            null,
            Response.Listener<JSONObject>{ response ->
                try {
                    val x = response.toMap()
                    res?.text = "Res: ${x["email"]}"
                } catch (e: Exception){
                    textView?.text = "Exception: $e"
                }
            },
            Response.ErrorListener{
                res?.text = "Volley Error: $it"
            })
        {
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["Authorization"] = args
                //..add other headers
                return params
            }
        }
            MySingleton.getInstance(this).addToRequestQueue(req)
        }

        private fun getToken(textView: TextView) {
        textView.text = ""

        val url = "https://api.intra.42.fr/oauth/token?grant_type=client_credentials&client_id=5b3ab3bacdf8b5f4ef716b3b757a2512fdbb3b0242a5c7a447891013e40c100b&client_secret=e249c191bf0551c1c5c0ff0b2e54181d50045d56941cc21d31fcf27932c00737"

        val req = JsonObjectRequest(Request.Method.POST,
            url,
            null,
            { response ->
                try {
                    textView.text = "Res: $response"
                    token = JSONObject(response.toString()).toMap()
                } catch (e:Exception){
                    textView.text = "Exception: $e"
                }
            },
            {
                textView.text = "Volley Error: $it"
            })
        req.retryPolicy = DefaultRetryPolicy(
            DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 1f
        )
        MySingleton.getInstance(this).addToRequestQueue(req)
    }
}


fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
    when (val value = this[it]) {
        is JSONArray -> {
            val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
            JSONObject(map).toMap().values.toList()
        }
        is JSONObject -> value.toMap()
        JSONObject.NULL -> null
        else -> value
    }
}