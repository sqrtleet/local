package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.providers.CreateProviderRequestDto
import com.example.startup_mobile.data.dto.providers.PaymentDetailsDto
import com.example.startup_mobile.data.dto.providers.ProviderListResponseDto
import com.example.startup_mobile.data.dto.providers.ProviderResponseDto
import com.example.startup_mobile.data.dto.providers.VerificationStatus as DtoVerificationStatus
import com.example.startup_mobile.data.dto.providers.UpdateProviderRequestDto
import com.example.startup_mobile.domain.CreateProviderPayload
import com.example.startup_mobile.domain.PaymentDetails
import com.example.startup_mobile.domain.Provider
import com.example.startup_mobile.domain.UpdateProviderPayload
import com.example.startup_mobile.domain.VerificationStatus as DomainVerificationStatus

private fun mapVerificationStatus(status: DtoVerificationStatus?): DomainVerificationStatus? =
    status?.let { DomainVerificationStatus.valueOf(it.name) }

fun ProviderResponseDto.toDomain(): Provider = Provider(
    id = id,
    userId = userId,
    region = region,
    city = city,
    specializations = specializations,
    bio = bio,
    experienceYears = experienceYears,
    languages = languages,
    verificationStatus = mapVerificationStatus(verificationStatus) ?: DomainVerificationStatus.PENDING,
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

fun ProviderListResponseDto.toDomain(): Provider = Provider(
    id = id,
    userId = userId,
    region = region,
    city = city,
    specializations = specializations,
    bio = bio,
    experienceYears = experienceYears,
    languages = languages,
    verificationStatus = mapVerificationStatus(verificationStatus) ?: DomainVerificationStatus.PENDING,
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
    paymentDetails = paymentDetails?.toDto(),
)

fun PaymentDetails.toDto(): PaymentDetailsDto = PaymentDetailsDto(
    bankName = bankName,
    accountNumber = accountNumber,
    cardNumber = cardNumber,
    phone = phone,
)

fun DomainVerificationStatus.toDto(): DtoVerificationStatus = DtoVerificationStatus.valueOf(name)
