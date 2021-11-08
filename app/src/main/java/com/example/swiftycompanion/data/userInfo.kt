package com.example.swiftycompanion.data

import com.google.gson.annotations.SerializedName

data class UserInfo(
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
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("alumni")
    val alumni: Boolean,
    @SerializedName("is_launched")
    val isLaunched: Boolean,
    @SerializedName("groups")
    val groups: List<Any>,
    @SerializedName("cursus_users")
    val cursusUsers: List<CursusUser>,
    @SerializedName("projects_users")
    val projectsUsers: List<ProjectsUser>,
    @SerializedName("languages_users")
    val languagesUsers: List<LanguagesUser>,
    @SerializedName("achievements")
    val achievements: List<Achievement>,
    @SerializedName("titles")
    val titles: List<Any>,
    @SerializedName("titles_users")
    val titlesUsers: List<Any>,
    @SerializedName("partnerships")
    val partnerships: List<Any>,
    @SerializedName("patroned")
    val patroned: List<Any>,
    @SerializedName("patroning")
    val patroning: List<Any>,
    @SerializedName("expertises_users")
    val expertisesUsers: List<ExpertisesUser>,
    @SerializedName("roles")
    val roles: List<Any>,
    @SerializedName("campus")
    val campus: List<Campu>,
    @SerializedName("campus_users")
    val campusUsers: List<CampusUser>,
)