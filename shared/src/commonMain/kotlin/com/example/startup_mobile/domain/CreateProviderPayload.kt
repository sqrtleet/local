package com.example.startup_mobile.domain

data class CreateProviderPayload(
    val region: String,
    val city: String? = null,
    val specializations: List<String> = emptyList(),
    val bio: String? = null,
    val experienceYears: Int = 0,
    val languages: List<String> = listOf("Русский"),
)
