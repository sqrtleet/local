package com.example.startup_mobile.domain

data class UpdateProviderPayload(
    val region: String? = null,
    val city: String? = null,
    val specializations: List<String>? = null,
    val bio: String? = null,
    val experienceYears: Int? = null,
    val languages: List<String>? = null,
)
