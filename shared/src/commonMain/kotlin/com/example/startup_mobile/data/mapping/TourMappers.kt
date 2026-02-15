package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.tours.CoordinatesDto
import com.example.startup_mobile.data.dto.tours.TourCategory as DtoTourCategory
import com.example.startup_mobile.data.dto.tours.TourCreateDto
import com.example.startup_mobile.data.dto.tours.TourImageCreateDto
import com.example.startup_mobile.data.dto.tours.TourImageResponseDto
import com.example.startup_mobile.data.dto.tours.TourListResponseDto
import com.example.startup_mobile.data.dto.tours.TourResponseDto
import com.example.startup_mobile.data.dto.tours.TourRoutePointCreateDto
import com.example.startup_mobile.data.dto.tours.TourRoutePointResponseDto
import com.example.startup_mobile.data.dto.tours.TourStatus as DtoTourStatus
import com.example.startup_mobile.data.dto.tours.TourUpdateDto
import com.example.startup_mobile.domain.CoordinatesInput
import com.example.startup_mobile.domain.CreateTourPayload
import com.example.startup_mobile.domain.Tour
import com.example.startup_mobile.domain.TourCategory as DomainTourCategory
import com.example.startup_mobile.domain.TourImage
import com.example.startup_mobile.domain.TourImageCreateInput
import com.example.startup_mobile.domain.TourRoutePoint
import com.example.startup_mobile.domain.TourRoutePointCreateInput
import com.example.startup_mobile.domain.TourStatus as DomainTourStatus
import com.example.startup_mobile.domain.UpdateTourPayload

private fun mapTourCategory(category: DtoTourCategory?): DomainTourCategory? =
    category?.let { DomainTourCategory.valueOf(it.name) }

private fun mapTourStatus(status: DtoTourStatus?): DomainTourStatus? =
    status?.let { DomainTourStatus.valueOf(it.name) }

fun TourListResponseDto.toDomain(): Tour = Tour(
    id = id,
    providerId = providerId,
    title = title,
    description = shortDescription ?: "",
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

fun CoordinatesInput.toDto(): CoordinatesDto = CoordinatesDto(lat = lat, lng = lng)

fun TourImageCreateInput.toDto(): TourImageCreateDto = TourImageCreateDto(
    url = url,
    thumbnailUrl = thumbnailUrl,
    altText = altText,
    order = order,
    isCover = isCover,
)

fun TourRoutePointCreateInput.toDto(): TourRoutePointCreateDto = TourRoutePointCreateDto(
    title = title,
    description = description,
    coordinates = coordinates?.toDto(),
    durationMinutes = durationMinutes,
    order = order,
)

fun CreateTourPayload.toDto(): TourCreateDto = TourCreateDto(
    title = title,
    description = description,
    shortDescription = shortDescription,
    category = DtoTourCategory.valueOf(category.name),
    price = price,
    currency = currency,
    durationHours = durationHours,
    maxParticipants = maxParticipants,
    minParticipants = minParticipants,
    region = region,
    city = city,
    meetingPoint = meetingPoint,
    coordinates = coordinates?.toDto(),
    included = included,
    notIncluded = notIncluded,
    requirements = requirements,
    difficultyLevel = difficultyLevel,
    languages = languages,
    cancellationPolicy = cancellationPolicy,
    images = images.map { it.toDto() },
    routePoints = routePoints.map { it.toDto() },
)

fun UpdateTourPayload.toDto(): TourUpdateDto = TourUpdateDto(
    title = title,
    description = description,
    shortDescription = shortDescription,
    category = category?.let { DtoTourCategory.valueOf(it.name) },
    price = price,
    currency = currency,
    durationHours = durationHours,
    maxParticipants = maxParticipants,
    minParticipants = minParticipants,
    region = region,
    city = city,
    meetingPoint = meetingPoint,
    coordinates = coordinates?.toDto(),
    included = included,
    notIncluded = notIncluded,
    requirements = requirements,
    difficultyLevel = difficultyLevel,
    languages = languages,
    cancellationPolicy = cancellationPolicy,
    status = status?.let { DtoTourStatus.valueOf(it.name) },
)
