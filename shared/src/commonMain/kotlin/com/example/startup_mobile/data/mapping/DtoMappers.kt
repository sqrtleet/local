package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.bookings.BookingListResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingStatus as DtoBookingStatus
import com.example.startup_mobile.data.dto.bookings.PaymentStatus as DtoPaymentStatus
import com.example.startup_mobile.data.dto.providers.CreateProviderRequestDto
import com.example.startup_mobile.data.dto.providers.PaymentDetailsDto
import com.example.startup_mobile.data.dto.providers.ProviderListResponseDto
import com.example.startup_mobile.data.dto.providers.ProviderResponseDto
import com.example.startup_mobile.data.dto.providers.VerificationStatus as DtoVerificationStatus
import com.example.startup_mobile.data.dto.tours.TourCategory as DtoTourCategory
import com.example.startup_mobile.data.dto.tours.TourImageResponseDto
import com.example.startup_mobile.data.dto.tours.TourListResponseDto
import com.example.startup_mobile.data.dto.tours.TourResponseDto
import com.example.startup_mobile.data.dto.tours.TourRoutePointResponseDto
import com.example.startup_mobile.data.dto.tours.TourStatus as DtoTourStatus
import com.example.startup_mobile.data.dto.providers.UpdateProviderRequestDto
import com.example.startup_mobile.data.dto.users.UserDto
import com.example.startup_mobile.data.dto.users.UserRole as DtoUserRole
import com.example.startup_mobile.data.dto.users.UserStatus as DtoUserStatus
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
import com.example.startup_mobile.domain.Booking
import com.example.startup_mobile.domain.BookingStatus as DomainBookingStatus
import com.example.startup_mobile.domain.CreateProviderPayload
import com.example.startup_mobile.domain.PaymentDetails
import com.example.startup_mobile.domain.Provider
import com.example.startup_mobile.domain.VerificationStatus as DomainVerificationStatus
import com.example.startup_mobile.domain.Tour
import com.example.startup_mobile.domain.TourCategory as DomainTourCategory
import com.example.startup_mobile.domain.TourImage
import com.example.startup_mobile.domain.TourRoutePoint
import com.example.startup_mobile.domain.TourStatus as DomainTourStatus
import com.example.startup_mobile.domain.UpdateProviderPayload
import com.example.startup_mobile.domain.User
import com.example.startup_mobile.domain.UserRole as DomainUserRole
import com.example.startup_mobile.domain.UserStatus as DomainUserStatus
import com.example.startup_mobile.domain.CreateTravelRequestOfferPayload
import com.example.startup_mobile.domain.CreateTravelRequestPayload
import com.example.startup_mobile.domain.PaymentStatus as DomainPaymentStatus
import com.example.startup_mobile.domain.OfferStatus as DomainOfferStatus
import com.example.startup_mobile.domain.RequestStatus as DomainRequestStatus
import com.example.startup_mobile.domain.TravelRequest
import com.example.startup_mobile.domain.TravelRequestOffer
import com.example.startup_mobile.domain.UpdateTravelRequestOfferPayload
import com.example.startup_mobile.domain.UpdateTravelRequestPayload
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

private fun parseInstant(value: String?): Instant? =
    value?.let { runCatching { Instant.parse(it) }.getOrNull() }

private fun parseLocalDate(value: String?): LocalDate? =
    value?.let { runCatching { LocalDate.parse(it) }.getOrNull() }

private fun mapRequestStatus(status: DtoRequestStatus?): DomainRequestStatus? =
    status?.let { DomainRequestStatus.valueOf(it.name) }

private fun mapOfferStatus(status: DtoOfferStatus?): DomainOfferStatus? =
    status?.let { DomainOfferStatus.valueOf(it.name) }

private fun mapUserRole(role: DtoUserRole?): DomainUserRole? =
    role?.let { DomainUserRole.valueOf(it.name) }

private fun mapUserStatus(status: DtoUserStatus?): DomainUserStatus? =
    status?.let { DomainUserStatus.valueOf(it.name) }

private fun mapVerificationStatus(status: DtoVerificationStatus?): DomainVerificationStatus? =
    status?.let { DomainVerificationStatus.valueOf(it.name) }

private fun mapBookingStatus(status: DtoBookingStatus?): DomainBookingStatus? =
    status?.let { DomainBookingStatus.valueOf(it.name) }

private fun mapPaymentStatus(status: DtoPaymentStatus?): DomainPaymentStatus? =
    status?.let { DomainPaymentStatus.valueOf(it.name) }

private fun mapTourCategory(category: DtoTourCategory?): DomainTourCategory? =
    category?.let { DomainTourCategory.valueOf(it.name) }

private fun mapTourStatus(status: DtoTourStatus?): DomainTourStatus? =
    status?.let { DomainTourStatus.valueOf(it.name) }

fun UserDto.toDomain(): User = User(
    id = id,
    telegramId = telegramId,
    role = mapUserRole(role) ?: DomainUserRole.TRAVELER,
    status = mapUserStatus(status) ?: DomainUserStatus.ACTIVE,
    name = name,
    username = username,
    avatarUrl = avatarUrl,
    phone = phone,
    email = email,
    rating = rating,
    reviewsCount = reviewsCount,
    createdAt = parseInstant(createdAt),
    updatedAt = parseInstant(updatedAt),
    isProvider = isProvider,
    providerId = providerId,
    verificationStatus = verificationStatus,
)

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


fun TourListResponseDto.toDomain(): Tour = Tour(
    id = id,
    providerId = providerId,
    title = title,
    shortDescription = shortDescription,
    category = mapTourCategory(category),
    price = price,
    currency = currency,
    durationHours = durationHours,
    maxParticipants = maxParticipants,
    region = region,
    city = city,
    status = mapTourStatus(status),
    rating = rating,
    reviewsCount = reviewsCount,
    coverImage = coverImage,
    providerName = providerName,
    providerRating = providerRating,
    providerVerified = providerVerified,
)

fun TourResponseDto.toDomain(): Tour = Tour(
    id = id,
    providerId = providerId,
    title = title,
    description = description,
    shortDescription = shortDescription,
    category = mapTourCategory(category),
    price = price,
    currency = currency,
    durationHours = durationHours,
    maxParticipants = maxParticipants,
    minParticipants = minParticipants,
    region = region,
    city = city,
    meetingPoint = meetingPoint,
    coordinates = coordinates,
    status = mapTourStatus(status),
    rating = rating,
    reviewsCount = reviewsCount,
    bookingsCount = bookingsCount,
    viewsCount = viewsCount,
    included = included,
    notIncluded = notIncluded,
    requirements = requirements,
    difficultyLevel = difficultyLevel,
    languages = languages,
    cancellationPolicy = cancellationPolicy,
    images = images.map { it.toDomain() },
    routePoints = routePoints.map { it.toDomain() },
    createdAt = parseInstant(createdAt),
    updatedAt = parseInstant(updatedAt),
    publishedAt = parseInstant(publishedAt),
    providerName = providerName,
    providerAvatar = providerAvatar,
    providerRating = providerRating,
    providerVerified = providerVerified,
)

fun TourImageResponseDto.toDomain(): TourImage = TourImage(
    id = id,
    url = url,
    thumbnailUrl = thumbnailUrl,
    altText = altText,
    order = order,
    isCover = isCover,
)

fun TourRoutePointResponseDto.toDomain(): TourRoutePoint = TourRoutePoint(
    id = id,
    title = title,
    description = description,
    coordinates = coordinates,
    durationMinutes = durationMinutes,
    order = order,
)

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
    languages = emptyList(),
    verificationStatus = mapVerificationStatus(verificationStatus) ?: DomainVerificationStatus.PENDING,
    verificationNote = null,
    verifiedAt = null,
    createdAt = null,
    updatedAt = null,
    userName = userName,
    userAvatar = userAvatar,
    userRating = userRating,
    userReviewsCount = 0,
    toursCount = 0,
    completedBookings = 0,
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
