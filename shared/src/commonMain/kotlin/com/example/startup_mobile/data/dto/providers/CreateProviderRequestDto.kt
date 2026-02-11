package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateProviderRequestDto(
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("specializations") val specializations: List<String> = emptyList(),
    @SerialName("bio") val bio: String? = null,
    @SerialName("experience_years") val experienceYears: Int = 0,
    @SerialName("languages") val languages: List<String> = listOf("Русский"),
)