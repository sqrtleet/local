package com.example.startup_mobile.domain

data class User(
    val id: String,
    val email: String,
    val displayName: String?,
    val avatarUrl: String?,
)
