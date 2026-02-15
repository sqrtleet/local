package com.example.startup_mobile

import com.example.startup_mobile.data.dto.bookings.BookingStatsResponseDto
import com.example.startup_mobile.data.dto.common.MessageResponseDto
import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.domain.BookingStats
import com.example.startup_mobile.domain.CancelBookingPayload
import com.example.startup_mobile.domain.MessageResult
import kotlin.test.Test
import kotlin.test.assertEquals

class DtoMappersTest {

    @Test
    fun bookingStatsResponseDto_toDomain() {
        val dto = BookingStatsResponseDto(
            totalBookings = 10,
            pendingBookings = 2,
            confirmedBookings = 5,
            completedBookings = 3,
            cancelledBookings = 0,
            totalRevenue = "1000.50",
            totalPayout = "900.00",
        )
        val domain = dto.toDomain()
        assertEquals(10, domain.totalBookings)
        assertEquals(2, domain.pendingBookings)
        assertEquals("1000.50", domain.totalRevenue)
        assertEquals("900.00", domain.totalPayout)
    }

    @Test
    fun bookingStatsResponseDto_toDomain_defaults() {
        val dto = BookingStatsResponseDto()
        val domain = dto.toDomain()
        assertEquals(0, domain.totalBookings)
        assertEquals("0.00", domain.totalRevenue)
    }

    @Test
    fun messageResponseDto_toDomain() {
        val dto = MessageResponseDto(message = "Done")
        val domain = dto.toDomain()
        assertEquals("Done", domain.message)
    }

    @Test
    fun cancelBookingPayload_toDto() {
        val payload = CancelBookingPayload(reason = "Changed plans")
        val dto = payload.toDto()
        assertEquals("Changed plans", dto.reason)
    }
}
