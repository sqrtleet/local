package com.example.startup_mobile.data.dto.bookings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingListResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("tour_id") val tourId: Int? = null,
    @SerialName("booking_date") val bookingDate: String,
    @SerialName("participants_count") val participantsCount: Int,
    @SerialName("status") val status: BookingStatus,
    @SerialName("payment_status") val paymentStatus: PaymentStatus,
    @SerialName("total_price") val totalPrice: String,
    @SerialName("currency") val currency: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("expires_at") val expiresAt: String? = null,
    @SerialName("tour_title") val tourTitle: String? = null,
    @SerialName("tour_image") val tourImage: String? = null,
    @SerialName("other_party_name") val otherPartyName: String? = null,
)
