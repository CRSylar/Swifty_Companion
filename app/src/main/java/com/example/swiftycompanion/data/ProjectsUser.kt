package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class ProjectsUser(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("current_team_id")
    val currentTeamId: Int,
    @SerializedName("cursus_id")
    val cursusIds: List<Int>,
    @SerializedName("final_mark")
    val finalMark: Int?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("marked")
    val marked: Boolean,
    @SerializedName("marked_at")
    val markedAt: String?,
    @SerializedName("occurrence")
    val occurrence: Int,
    @SerializedName("project")
    val project: Project,
    @SerializedName("retriable_at")
    val retriableAt: String?,
    @SerializedName("status")
    val status: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("validated?")
    val validated: Boolean?
)