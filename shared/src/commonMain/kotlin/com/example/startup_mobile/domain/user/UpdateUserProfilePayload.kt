package com.example.startup_mobile.domain

data class UpdateUserProfilePayload(
    val name: String? = null,
    val phone: String? = null,
    val email: String? = null,
    val avatarUrl: String? = null,
)
