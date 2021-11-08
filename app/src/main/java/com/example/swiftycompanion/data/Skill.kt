package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class Skill(
    @SerializedName("id")
    val id: Int,
    @SerializedName("level")
    val level: Double,
    @SerializedName("name")
    val name: String
)