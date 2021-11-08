package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class ExpertisesUser(
    @SerializedName("contact_me")
    val contactMe: Boolean,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("expertise_id")
    val expertiseId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("interested")
    val interested: Boolean,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("value")
    val value: Int
)