package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("usual_first_name")
    val usualFirstName: Any?,
    @SerializedName("usual_full_name")
    val usualFullName: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("displayname")
    val displayname: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("staff?")
    val staff: Boolean,
    @SerializedName("correction_point")
    val correctionPoint: Int,
    @SerializedName("pool_month")
    val poolMonth: String,
    @SerializedName("pool_year")
    val poolYear: String,
    @SerializedName("location")
    val location: Any?,
    @SerializedName("wallet")
    val wallet: Int,
    @SerializedName("anonymize_date")
    val anonymizeDate: String,
    @SerializedName("crated_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("alumni")
    val alumni: Boolean,
    @SerializedName("is_launched?")
    val isLaunched: Boolean,
)