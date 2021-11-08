package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class Cursus(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)