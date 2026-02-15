package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.travelRequests.OfferAcceptDto
import com.example.startup_mobile.data.dto.travelRequests.OfferDeclineDto
import com.example.startup_mobile.data.dto.travelRequests.OfferStatus as DtoOfferStatus
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferCreateDto
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferListResponseDto
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferResponseDto
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferUpdateDto
import com.example.startup_mobile.data.dto.travelRequests.RequestStatus as DtoRequestStatus
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestCreateDto
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestListResponse
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestResponse
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestUpdateDto
import com.example.startup_mobile.domain.AcceptOfferPayload
import com.example.startup_mobile.domain.CreateTravelRequestOfferPayload
import com.example.startup_mobile.domain.CreateTravelRequestPayload
import com.example.startup_mobile.domain.DeclineOfferPayload
import com.example.startup_mobile.domain.OfferStatus as DomainOfferStatus
import com.example.startup_mobile.domain.RequestStatus as DomainRequestStatus
import com.example.startup_mobile.domain.TravelRequest
import com.example.startup_mobile.domain.TravelRequestOffer
import com.example.startup_mobile.domain.UpdateTravelRequestOfferPayload
import com.example.startup_mobile.domain.UpdateTravelRequestPayload

private fun mapRequestStatus(status: DtoRequestStatus?): DomainRequestStatus? =
    status?.let { DomainRequestStatus.valueOf(it.name) }

private fun mapOfferStatus(status: DtoOfferStatus?): DomainOfferStatus? =
    status?.let { DomainOfferStatus.valueOf(it.name) }

fun TravelRequestListResponse.toDomain(): TravelRequest = TravelRequest(
    id = id,
    region = region,
    city = city,
    title = title,
    dateFrom = parseLocalDate(dateFrom),
    dateTo = parseLocalDate(dateTo),
    participantsCount = participantsCount,
    budgetMin = budgetMin,
    budgetMax = budgetMax,
    currency = currency,
    status = mapRequestStatus(status),
    categories = categories,
    offersCount = offersCount,
    createdAt = parseInstant(createdAt),
    userName = userName,
)

fun TravelRequestResponse.toDomain(): TravelRequest = TravelRequest(
    id = id,
    userId = userId,
    region = region,
    city = city,
    title = title,
    description = description,
    categories = categories,
    dateFrom = parseLocalDate(dateFrom),
    dateTo = parseLocalDate(dateTo),
    flexibleDates = flexibleDates,
    participantsCount = participantsCount,
    participantsInfo = participantsInfo,
    budgetMin = budgetMin,
    budgetMax = budgetMax,
    currency = currency,
    status = mapRequestStatus(status),
    languages = languages,
    specialRequirements = specialRequirements,
    expiresAt = parseInstant(expiresAt),
    createdAt = parseInstant(createdAt),
    updatedAt = parseInstant(updatedAt),
    offersCount = offersCount,
    userName = userName,
    userAvatar = userAvatar,
)

fun ProviderOfferResponseDto.toDomain(): TravelRequestOffer = TravelRequestOffer(
    id = id,
    travelRequestId = travelRequestId,
    providerId = providerId,
    tourId = tourId,
    title = title,
    description = description,
    pricePerPerson = pricePerPerson,
    totalPrice = totalPrice,
    currency = currency,
    proposedDate = parseLocalDate(proposedDate),
    proposedTime = proposedTime,
    durationHours = durationHours,
    maxParticipants = maxParticipants,
    included = included,
    notIncluded = notIncluded,
    meetingPoint = meetingPoint,
    status = mapOfferStatus(status),
    providerMessage = providerMessage,
    declineReason = declineReason,
    expiresAt = parseInstant(expiresAt),
    createdAt = parseInstant(createdAt),
    updatedAt = parseInstant(updatedAt),
    respondedAt = parseInstant(respondedAt),
    bookingId = bookingId,
    providerName = providerName,
    providerAvatar = providerAvatar,
    providerRating = providerRating,
    providerReviewsCount = providerReviewsCount,
    tourTitle = tourTitle,
    tourImage = tourImage,
)

fun ProviderOfferListResponseDto.toDomain(): TravelRequestOffer = TravelRequestOffer(
    id = id,
    travelRequestId = travelRequestId,
    title = title,
    pricePerPerson = pricePerPerson,
    totalPrice = totalPrice,
    currency = currency,
    proposedDate = parseLocalDate(proposedDate),
    durationHours = durationHours,
    status = mapOfferStatus(status),
    createdAt = parseInstant(createdAt),
    providerName = providerName,
    providerAvatar = providerAvatar,
)

fun CreateTravelRequestPayload.toDto(): TravelRequestCreateDto = TravelRequestCreateDto(
    region = region,
    city = city,
    title = title,
    description = description,
    categories = categories,
    dateFrom = dateFrom.toString(),
    dateTo = dateTo.toString(),
    flexibleDates = flexibleDates,
    participantsCount = participantsCount,
    participantsInfo = participantsInfo,
    budgetMin = budgetMin,
    budgetMax = budgetMax,
    currency = currency,
    languages = languages,
    specialRequirements = specialRequirements,
)

fun UpdateTravelRequestPayload.toDto(): TravelRequestUpdateDto = TravelRequestUpdateDto(
    region = region,
    city = city,
    title = title,
    description = description,
    categories = categories,
    dateFrom = dateFrom?.toString(),
    dateTo = dateTo?.toString(),
    flexibleDates = flexibleDates,
    participantsCount = participantsCount,
    participantsInfo = participantsInfo,
    budgetMin = budgetMin,
    budgetMax = budgetMax,
    languages = languages,
    specialRequirements = specialRequirements,
)

fun CreateTravelRequestOfferPayload.toDto(): ProviderOfferCreateDto = ProviderOfferCreateDto(
    title = title,
    description = description,
    travelRequestId = travelRequestId,
    tourId = tourId,
    pricePerPerson = pricePerPerson,
    currency = currency,
    proposedDate = proposedDate.toString(),
    proposedTime = proposedTime,
    durationHours = durationHours,
    maxParticipants = maxParticipants,
    included = included,
    notIncluded = notIncluded,
    meetingPoint = meetingPoint,
    providerMessage = providerMessage,
)

fun UpdateTravelRequestOfferPayload.toDto(): ProviderOfferUpdateDto = ProviderOfferUpdateDto(
    title = title,
    description = description,
    pricePerPerson = pricePerPerson,
    proposedDate = proposedDate?.toString(),
    proposedTime = proposedTime,
    durationHours = durationHours,
    included = included,
    notIncluded = notIncluded,
    meetingPoint = meetingPoint,
    providerMessage = providerMessage,
)

fun DomainRequestStatus.toDto(): DtoRequestStatus = DtoRequestStatus.valueOf(name)
fun DomainOfferStatus.toDto(): DtoOfferStatus = DtoOfferStatus.valueOf(name)

fun AcceptOfferPayload.toDto(): OfferAcceptDto = OfferAcceptDto(
    contactName = contactName,
    contactPhone = contactPhone,
    contactEmail = contactEmail,
    notes = notes,
)

fun DeclineOfferPayload.toDto(): OfferDeclineDto = OfferDeclineDto(reason = reason)
