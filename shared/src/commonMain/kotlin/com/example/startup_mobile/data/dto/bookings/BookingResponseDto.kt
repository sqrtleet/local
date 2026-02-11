package com.example.startup_mobile.data.dto.bookings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("tour_id") val tourId: Int? = null,
    @SerialName("traveler_id") val travelerId: Int,
    @SerialName("booking_date") val bookingDate: String,
    @SerialName("booking_time") val bookingTime: String? = null,
    @SerialName("participants_count") val participantsCount: Int,
    @SerialName("status") val status: BookingStatus,
    @SerialName("payment_status") val paymentStatus: PaymentStatus,
    @SerialName("unit_price") val unitPrice: String,
    @SerialName("total_price") val totalPrice: String,
    @SerialName("platform_fee") val platformFee: String,
    @SerialName("provider_payout") val providerPayout: String,
    @SerialName("currency") val currency: String,
    @SerialName("contact_name") val contactName: String? = null,
    @SerialName("contact_phone") val contactPhone: String? = null,
    @SerialName("contact_email") val contactEmail: String? = null,
    @SerialName("traveler_notes") val travelerNotes: String? = null,
    @SerialName("provider_notes") val providerNotes: String? = null,
    @SerialName("cancellation_reason") val cancellationReason: String? = null,
    @SerialName("provider_confirmed_at") val providerConfirmedAt: String? = null,
    @SerialName("traveler_completed_at") val travelerCompletedAt: String? = null,
    @SerialName("expires_at") val expiresAt: String? = null,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("tour_title") val tourTitle: String? = null,
    @SerialName("tour_image") val tourImage: String? = null,
    @SerialName("tour_region") val tourRegion: String? = null,
    @SerialName("traveler_name") val travelerName: String? = null,
    @SerialName("traveler_avatar") val travelerAvatar: String? = null,
    @SerialName("provider_name") val providerName: String? = null,
    @SerialName("provider_id") val providerId: Int? = null,
)
