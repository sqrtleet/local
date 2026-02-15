package com.example.startup_mobile

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.bookings.BookingListResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingStatsResponseDto
import com.example.startup_mobile.data.repository.DefaultBookingsRepository
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class DefaultBookingsRepositoryTest {

    @Test
    fun getBookingStats_mapsDtoToDomain() = runBlocking {
        val statsDto = BookingStatsResponseDto(
            totalBookings = 7,
            pendingBookings = 1,
            confirmedBookings = 2,
            completedBookings = 4,
            cancelledBookings = 0,
            totalRevenue = "500.00",
            totalPayout = "450.00",
        )
        val api = object : com.example.startup_mobile.data.remote.BookingsApi {
            override suspend fun getMyBookings(
                page: Int?,
                perPage: Int?,
                status: com.example.startup_mobile.data.dto.bookings.BookingStatus?,
            ): PaginatedResponse<BookingListResponseDto> =
                PaginatedResponse(emptyList(), 0, 1, 10, 0)
            override suspend fun getProviderBookings(
                page: Int?,
                perPage: Int?,
                status: com.example.startup_mobile.data.dto.bookings.BookingStatus?,
            ): PaginatedResponse<BookingListResponseDto> =
                PaginatedResponse(emptyList(), 0, 1, 10, 0)
            override suspend fun getBookingStats(): BookingStatsResponseDto? = statsDto
            override suspend fun getBooking(id: Int): com.example.startup_mobile.data.dto.bookings.BookingResponseDto? = null
            override suspend fun cancelBooking(
                id: Int,
                body: com.example.startup_mobile.data.dto.bookings.BookingCancelDto,
            ): com.example.startup_mobile.data.dto.bookings.BookingResponseDto? = null
            override suspend fun completeBooking(id: Int): com.example.startup_mobile.data.dto.bookings.BookingResponseDto? = null
        }
        val repo = DefaultBookingsRepository(api)
        val result = repo.getBookingStats()
        assertEquals(7, result?.totalBookings)
        assertEquals(1, result?.pendingBookings)
        assertEquals("500.00", result?.totalRevenue)
    }

    @Test
    fun getBookingStats_returnsNullWhenApiReturnsNull() = runBlocking {
        val api = object : com.example.startup_mobile.data.remote.BookingsApi {
            override suspend fun getMyBookings(
                page: Int?,
                perPage: Int?,
                status: com.example.startup_mobile.data.dto.bookings.BookingStatus?,
            ): PaginatedResponse<BookingListResponseDto> =
                PaginatedResponse(emptyList(), 0, 1, 10, 0)
            override suspend fun getProviderBookings(
                page: Int?,
                perPage: Int?,
                status: com.example.startup_mobile.data.dto.bookings.BookingStatus?,
            ): PaginatedResponse<BookingListResponseDto> =
                PaginatedResponse(emptyList(), 0, 1, 10, 0)
            override suspend fun getBookingStats(): BookingStatsResponseDto? = null
            override suspend fun getBooking(id: Int): com.example.startup_mobile.data.dto.bookings.BookingResponseDto? = null
            override suspend fun cancelBooking(
                id: Int,
                body: com.example.startup_mobile.data.dto.bookings.BookingCancelDto,
            ): com.example.startup_mobile.data.dto.bookings.BookingResponseDto? = null
            override suspend fun completeBooking(id: Int): com.example.startup_mobile.data.dto.bookings.BookingResponseDto? = null
        }
        val repo = DefaultBookingsRepository(api)
        assertNull(repo.getBookingStats())
    }
}
