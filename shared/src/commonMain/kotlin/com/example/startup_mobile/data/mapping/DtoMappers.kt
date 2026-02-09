package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.bookings.BookingDto
import com.example.startup_mobile.data.dto.providers.CreateProviderRequestDto
import com.example.startup_mobile.data.dto.providers.ProviderDto
import com.example.startup_mobile.data.dto.tours.TourDto
import com.example.startup_mobile.data.dto.providers.UpdateProviderRequestDto
import com.example.startup_mobile.data.dto.users.UserDto
import com.example.startup_mobile.domain.Booking
import com.example.startup_mobile.domain.BookingStatus
import com.example.startup_mobile.domain.CreateProviderPayload
import com.example.startup_mobile.domain.Provider
import com.example.startup_mobile.domain.Tour
import com.example.startup_mobile.domain.UpdateProviderPayload
import com.example.startup_mobile.domain.User
import kotlinx.datetime.Instant

private fun parseInstant(value: String?): Instant? =
    value?.let { runCatching { Instant.parse(it) }.getOrNull() }

fun UserDto.toDomain(): User = User(
    id = id,
    email = email,
    displayName = displayName,
    avatarUrl = avatarUrl,
)


fun TourDto.toDomain(): Tour = Tour(
    id = id,
    title = title,
    description = description,
    imageUrl = imageUrl,
    location = location,
    startDate = parseInstant(startDate),
    endDate = parseInstant(endDate),
)

fun BookingDto.toDomain(): Booking = Booking(
    id = id,
    tourId = tourId,
    userId = userId,
    status = BookingStatus.entries.find { it.name.equals(status, ignoreCase = true) } ?: BookingStatus.PENDING,
    createdAt = parseInstant(createdAt),
)


fun ProviderDto.toDomain(): Provider = Provider(
    id = id,
    userId = userId,
    region = region,
    city = city,
    specializations = specializations,
    bio = bio,
    experienceYears = experienceYears,
    languages = languages,
    verificationStatus = verificationStatus,
    verificationNote = verificationNote,
    verifiedAt = parseInstant(verifiedAt),
    createdAt = parseInstant(createdAt),
    updatedAt = parseInstant(updatedAt),
    userName = userName,
    userAvatar = userAvatar,
    userRating = userRating,
    userReviewsCount = userReviewsCount,
    toursCount = toursCount,
    completedBookings = completedBookings,
)

fun CreateProviderPayload.toDto(): CreateProviderRequestDto = CreateProviderRequestDto(
    region = region,
    city = city,
    specializations = specializations,
    bio = bio,
    experienceYears = experienceYears,
    languages = languages,
)

fun UpdateProviderPayload.toDto(): UpdateProviderRequestDto = UpdateProviderRequestDto(
    region = region,
    city = city,
    specializations = specializations,
    bio = bio,
    experienceYears = experienceYears,
    languages = languages,
)
