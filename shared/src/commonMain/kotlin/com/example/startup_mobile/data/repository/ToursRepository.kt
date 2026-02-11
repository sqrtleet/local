package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.common.MessageResponseDto
import com.example.startup_mobile.domain.Tour
import com.example.startup_mobile.data.dto.tours.TourCreateDto
import com.example.startup_mobile.data.dto.tours.TourUpdateDto

interface ToursRepository {
    suspend fun getMyTours(page: Int? = null, perPage: Int? = null): PaginatedResponse<Tour>
    suspend fun createTour(body: TourCreateDto): Tour?
    suspend fun getTour(id: Int): Tour?
    suspend fun updateTour(id: Int, body: TourUpdateDto): Tour?
    suspend fun publishTour(id: Int): Tour?
    suspend fun archiveTour(id: Int): Tour?
    suspend fun addTourImage(
        id: Int,
        fileBytes: ByteArray,
        fileName: String,
        isCover: Boolean? = null,
    ): Tour?
    suspend fun deleteTourImage(tourId: Int, imageId: Int): MessageResponseDto?
}
