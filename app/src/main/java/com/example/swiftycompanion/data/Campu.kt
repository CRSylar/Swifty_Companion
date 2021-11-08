package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class Campu(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("default_hidden_phone")
    val defaultHiddenPhone: Boolean,
    @SerializedName("email_extension")
    val emailExtension: String,
    @SerializedName("facebook")
    val facebook: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("language")
    val language: Language,
    @SerializedName("name")
    val name: String,
    @SerializedName("time_zone")
    val timeZone: String,
    @SerializedName("twitter")
    val twitter: String,
    @SerializedName("users_count")
    val usersCount: Int,
    @SerializedName("vogsphere_id")
    val vogsphereId: Int,
    @SerializedName("website")
    val website: String,
    @SerializedName("zip")
    val zip: String
)