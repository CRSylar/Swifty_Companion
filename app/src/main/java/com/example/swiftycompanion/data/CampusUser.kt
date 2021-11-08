package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class CampusUser(
    @SerializedName("campus_id")
    val campusId: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_primary")
    val isPrimary: Boolean,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
)