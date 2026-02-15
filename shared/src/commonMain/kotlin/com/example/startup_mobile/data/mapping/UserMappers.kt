package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.users.UserDto
import com.example.startup_mobile.data.dto.users.UserListResponseDto
import com.example.startup_mobile.data.dto.users.UserRole as DtoUserRole
import com.example.startup_mobile.data.dto.users.UserStatus as DtoUserStatus
import com.example.startup_mobile.data.dto.users.UserStatusUpdateDto
import com.example.startup_mobile.data.dto.users.UserUpdateDto
import com.example.startup_mobile.domain.User
import com.example.startup_mobile.domain.UserRole as DomainUserRole
import com.example.startup_mobile.domain.UserStatus as DomainUserStatus
import com.example.startup_mobile.domain.UpdateUserProfilePayload
import com.example.startup_mobile.domain.UserStatusUpdatePayload

private fun mapUserRole(role: DtoUserRole?): DomainUserRole? =
    role?.let { DomainUserRole.valueOf(it.name) }

private fun mapUserStatus(status: DtoUserStatus?): DomainUserStatus? =
    status?.let { DomainUserStatus.valueOf(it.name) }

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

fun UserListResponseDto.toDomain(): User = User(
    id = id,
    telegramId = telegramId,
    role = mapUserRole(role) ?: DomainUserRole.TRAVELER,
    status = mapUserStatus(status) ?: DomainUserStatus.ACTIVE,
    name = name,
    username = username,
    avatarUrl = avatarUrl,
    phone = null,
    email = null,
    rating = rating,
    reviewsCount = reviewsCount,
    createdAt = parseInstant(createdAt),
    updatedAt = null,
    isProvider = false,
    providerId = null,
    verificationStatus = null,
)

fun UpdateUserProfilePayload.toDto(): UserUpdateDto = UserUpdateDto(
    name = name,
    phone = phone,
    email = email,
    avatarUrl = avatarUrl,
)

fun UserStatusUpdatePayload.toDto(): UserStatusUpdateDto = UserStatusUpdateDto(
    status = DtoUserStatus.valueOf(status.name),
    reason = reason,
)

fun DomainUserRole.toDto(): DtoUserRole = DtoUserRole.valueOf(name)
fun DomainUserStatus.toDto(): DtoUserStatus = DtoUserStatus.valueOf(name)
