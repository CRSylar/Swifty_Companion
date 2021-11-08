package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class LanguagesUser(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("language_id")
    val languageId: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("user_id")
    val userId: Int
)