package com.subhag.api.models.entities

data class UserEntity(
    val username: String = "",
    val email: String = "",
    val profileImage: String = "",
    val hasCustomImage:Boolean = false
)
