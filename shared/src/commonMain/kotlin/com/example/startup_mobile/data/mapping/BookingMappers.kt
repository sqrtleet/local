package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.bookings.BookingCancelDto
import com.example.startup_mobile.data.dto.bookings.BookingListResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingStatsResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingStatus as DtoBookingStatus
import com.example.startup_mobile.data.dto.bookings.PaymentStatus as DtoPaymentStatus
import com.example.startup_mobile.domain.Booking
import com.example.startup_mobile.domain.BookingStats
import com.example.startup_mobile.domain.BookingStatus as DomainBookingStatus
import com.example.startup_mobile.domain.CancelBookingPayload
import com.example.startup_mobile.domain.PaymentStatus as DomainPaymentStatus

private fun mapBookingStatus(status: DtoBookingStatus?): DomainBookingStatus? =
    status?.let { DomainBookingStatus.valueOf(it.name) }

private fun mapPaymentStatus(status: DtoPaymentStatus?): DomainPaymentStatus? =
    status?.let { DomainPaymentStatus.valueOf(it.name) }

fun BookingListResponseDto.toDomain(): Booking = Booking(
    id = id,
    tourId = tourId,
    bookingDate = bookingDate,
    participantsCount = participantsCount,
    status = mapBookingStatus(status) ?: DomainBookingStatus.PENDING,
    paymentStatus = mapPaymentStatus(paymentStatus),
    totalPrice = totalPrice,
    currency = currency,
    createdAt = parseInstant(createdAt),
    expiresAt = parseInstant(expiresAt),
    tourTitle = tourTitle,
    tourImage = tourImage,
)

fun BookingResponseDto.toDomain(): Booking = Booking(
    id = id,
    tourId = tourId,
    travelerId = travelerId,
    bookingDate = bookingDate,
    bookingTime = bookingTime,
    participantsCount = participantsCount,
    status = mapBookingStatus(status) ?: DomainBookingStatus.PENDING,
    paymentStatus = mapPaymentStatus(paymentStatus),
    unitPrice = unitPrice,
    totalPrice = totalPrice,
    platformFee = platformFee,
    providerPayout = providerPayout,
    currency = currency,
    contactName = contactName,
    contactPhone = contactPhone,
    contactEmail = contactEmail,
    travelerNotes = travelerNotes,
    providerNotes = providerNotes,
    cancellationReason = cancellationReason,
    providerConfirmedAt = parseInstant(providerConfirmedAt),
    travelerCompletedAt = parseInstant(travelerCompletedAt),
    expiresAt = parseInstant(expiresAt),
    createdAt = parseInstant(createdAt),
    updatedAt = parseInstant(updatedAt),
    tourTitle = tourTitle,
    tourImage = tourImage,
    tourRegion = tourRegion,
    travelerName = travelerName,
    travelerAvatar = travelerAvatar,
    providerName = providerName,
    providerId = providerId,
)

fun CancelBookingPayload.toDto(): BookingCancelDto = BookingCancelDto(reason = reason)

fun BookingStatsResponseDto.toDomain(): BookingStats = BookingStats(
    totalBookings = totalBookings,
    pendingBookings = pendingBookings,
    confirmedBookings = confirmedBookings,
    completedBookings = completedBookings,
    cancelledBookings = cancelledBookings,
    totalRevenue = totalRevenue,
    totalPayout = totalPayout,
)

fun DomainBookingStatus.toDto(): DtoBookingStatus = DtoBookingStatus.valueOf(name)
