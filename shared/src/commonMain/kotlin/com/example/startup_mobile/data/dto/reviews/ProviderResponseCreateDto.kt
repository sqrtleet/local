package com.example.startup_mobile.data.dto.reviews

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProviderResponseCreateDto(
    @SerialName("response") val response: String,
)
