package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class Achievement(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nbr_of_success")
    val nbrOfSuccess: Any?,
    @SerializedName("tier")
    val tier: String,
    @SerializedName("users_url")
    val usersUrl: String,
    @SerializedName("visible")
    val visible: Boolean
)