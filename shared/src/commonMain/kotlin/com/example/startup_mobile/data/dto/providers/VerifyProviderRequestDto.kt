package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifyProviderRequestDto(
    @SerialName("status") val status: VerificationStatus,
    @SerialName("note") val note: String? = null,
)
