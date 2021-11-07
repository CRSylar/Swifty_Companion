package com.example.swiftycompanion.data

import java.util.*

data class UserInfo(
    val id: Int,
    val email: String,
    val login :String,
    val firstName: String,
    val lastName:String,
    val phone: String,
    val displayName: String,
    val imageUrl:String,
    val correctionPoint: Int,
    val poolYear: String,
    val wallet: Int,
    val cursusUser: List<CursusUser>,
    val projectUser: List<Project>,
    val achievements: List<Achievement>,
    val campus: Campus

) {}

data class Campus(
    val name: String,
    val country: String,
    val address:String,
    val website: String
) {}

data class Achievement(
    val name: String,
    val description: String,
    val image: String
) {}

data class Project(
    val name: String,
    val finalMark: Int,
    val status: String,
) {}

data class CursusUser(
    val grade: String?,
    val level: Float,
    val skills: List<Skill>,
    val blackHoledAt: String?,
) {}

data class Skill(
    val name: String,
    val level: Float
) {}


