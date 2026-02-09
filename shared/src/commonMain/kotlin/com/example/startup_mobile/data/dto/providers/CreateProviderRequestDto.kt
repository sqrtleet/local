package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateProviderRequestDto(
    @SerialName("region") val region: String,
    @SerialName("city") val city: String,
    @SerialName("specializations") val specializations: List<String>,
    @SerialName("bio") val bio: String,
    @SerialName("experience_years") val experienceYears: Int,
    @SerialName("languages") val languages: List<String>,
)