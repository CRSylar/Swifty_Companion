package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class Project(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent_id")
    val parentId: Any?,
    @SerializedName("slug")
    val slug: String
)