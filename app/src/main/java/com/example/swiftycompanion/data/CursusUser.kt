package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class CursusUser(
    @SerializedName("grade")
    val grade: Any?,
    @SerializedName("level")
    val level: Double,
    @SerializedName("skills")
    val skills: List<Skill>,
    @SerializedName("blackholed_at")
    val blackholedAt: Any?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String?,
    @SerializedName("cursus_id")
    val cursusId: Int,
    @SerializedName("has_coalition")
    val hasCoalition: Boolean,
    @SerializedName("crated_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("cursus")
    val cursus: Cursus,
)