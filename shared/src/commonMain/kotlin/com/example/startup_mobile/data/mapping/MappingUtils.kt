package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.common.MessageResponseDto
import com.example.startup_mobile.domain.MessageResult
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

internal fun parseInstant(value: String?): Instant? =
    value?.let { runCatching { Instant.parse(it) }.getOrNull() }

internal fun parseLocalDate(value: String?): LocalDate? =
    value?.let { runCatching { LocalDate.parse(it) }.getOrNull() }

fun MessageResponseDto.toDomain(): MessageResult = MessageResult(message = message)
