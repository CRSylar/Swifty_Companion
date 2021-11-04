package com.example.swiftycompanion

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class OauthTokenManager(val context: Context) {

    fun getToken(): Map<String, *>? {
        var token: Map<String, *>? = null
        val url = "$uri?grant_type=client_credentials&client_id=$client_id&client_secret=$secret"
        val req = JsonObjectRequest(
            Request.Method.POST,
            url,
            null,
            { response ->
                try {
                    token = JSONObject(response.toString()).toMap()
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
        return token
    }

    fun showRes(userName: String?, access_token: String): Map<String, *> ? {
        var res : Map<String, *>? = null
        val url = "$searchUri$userName"
        val args = "Bearer $access_token}"
        val req = object : JsonObjectRequest(
            Method.GET,
            url,
            null,
            Response.Listener { response ->
                try {
                    res = response.toMap()
                } catch (e: Exception){
                    Toast.makeText(context, "Exception: $e", Toast.LENGTH_SHORT).show()
                }
                              },
            Response.ErrorListener{
                Toast.makeText(context, "Volley Error: $it", Toast.LENGTH_SHORT).show()
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
        return res
    }
}