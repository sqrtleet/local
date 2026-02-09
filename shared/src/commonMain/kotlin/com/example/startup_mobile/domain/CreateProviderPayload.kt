package com.example.startup_mobile.domain

data class CreateProviderPayload(
    val region: String,
    val city: String,
    val specializations: List<String>,
    val bio: String,
    val experienceYears: Int,
    val languages: List<String>,
)
