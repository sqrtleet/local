package com.example.startup_mobile.domain.repository

import com.example.startup_mobile.domain.CreateTourPayload
import com.example.startup_mobile.domain.MessageResult
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.Tour
import com.example.startup_mobile.domain.UpdateTourPayload

interface ToursRepository {
    suspend fun getMyTours(page: Int? = null, perPage: Int? = null): Page<Tour>
    suspend fun createTour(body: CreateTourPayload): Tour?
    suspend fun getTour(id: Int): Tour?
    suspend fun updateTour(id: Int, body: UpdateTourPayload): Tour?
    suspend fun publishTour(id: Int): Tour?
    suspend fun archiveTour(id: Int): Tour?
    suspend fun addTourImage(
        id: Int,
        fileBytes: ByteArray,
        fileName: String,
        isCover: Boolean? = null,
    ): Tour?
    suspend fun deleteTourImage(tourId: Int, imageId: Int): MessageResult?
}
