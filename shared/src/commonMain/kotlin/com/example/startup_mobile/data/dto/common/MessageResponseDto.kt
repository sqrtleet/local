package com.example.startup_mobile.data.dto.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class MessageResponseDto(
    @SerialName("message") val message: String,
    @SerialName("success") val success: Boolean = true,
    @SerialName("details") val details: JsonObject? = null,
)
