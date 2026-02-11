package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateProviderRequestDto(
    @SerialName("region") val region: String? = null,
    @SerialName("city") val city: String? = null,
    @SerialName("specializations") val specializations: List<String>? = null,
    @SerialName("bio") val bio: String? = null,
    @SerialName("experience_years") val experienceYears: Int? = null,
    @SerialName("languages") val languages: List<String>? = null,
    @SerialName("payment_details") val paymentDetails: PaymentDetailsDto? = null,
)
