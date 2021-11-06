package com.example.swiftycompanion

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.io.Serializable
import kotlin.properties.Delegates

interface MyInterface{
    fun onValueChanged(response: Boolean)
    fun onValueChanged(newToken: Map<String, *>)
    fun onUserChanged(newUserData: Map<String, *>)
}

class OauthTokenManager(val context: Context): MyInterface {

    val myInterface = this

    var validToken: Boolean by Delegates.observable(false) { property, oldValue, newValue ->
        if (!validToken){
            getToken()
            validToken = true
        }
    }
    var token: Map<String, *>? = null

    fun getToken() {
        val url = "$uri?grant_type=client_credentials&client_id=$client_id&client_secret=$secret"
        val req = JsonObjectRequest(
            Request.Method.POST,
            url,
            null,
            { response ->
                try {
                    myInterface.onValueChanged(JSONObject(response.toString()).toMap())
                } catch (e:Exception){
                    Toast.makeText(context, "Exception: $e", Toast.LENGTH_SHORT).show()
                }
            },
            {
                Toast.makeText(context, "Volley Error: $it", Toast.LENGTH_SHORT).show()
            })
        req.retryPolicy = DefaultRetryPolicy(
            DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 1f
        )
        MySingleton.getInstance(context).addToRequestQueue(req)
    }

    fun showRes(userName: String?) {
        val url = "$searchUri$userName"
        val args = "$header${token?.get("access_token")}"
        val req = object : JsonObjectRequest(
            Method.GET,
            url,
            null,
            Response.Listener { response ->
                try {
                    Log.d("Listener", response.toString())
                    myInterface.onUserChanged(response.toMap())
                } catch (e: Exception){
                    Toast.makeText(context, "Exception: $e", Toast.LENGTH_SHORT).show()
                }
                              },
            Response.ErrorListener{
                Toast.makeText(context, "Volley Error: $it", Toast.LENGTH_SHORT).show()
                listen.value = true
            })
        {
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["Authorization"] = args
                //..add other headers
                return params
            }
        }
        MySingleton.getInstance(context).addToRequestQueue(req)
    }

    fun checkToken() {
        val args = "$header${token?.get("access_token")}"
        val req = object : JsonObjectRequest(
            Method.GET,
            "$uri/info",
            null,
            Response.Listener { _ ->
                try {
                    myInterface.onValueChanged(true)
                } catch (e: Exception){
                    myInterface.onValueChanged(false)
                }
            },
            Response.ErrorListener {
                myInterface.onValueChanged(false)
            })
        {
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["Authorization"] = args
                //..add other headers
                return params
            }
        }
        MySingleton.getInstance(context).addToRequestQueue(req)
    }

    override fun onValueChanged(response: Boolean) {
        validToken = response
    }

    override fun onValueChanged(newToken: Map<String, *>) {
        token = newToken
    }

    override fun onUserChanged(newUserData: Map<String, *>) {
        g_userData = newUserData
        listen.value = true
    }
}