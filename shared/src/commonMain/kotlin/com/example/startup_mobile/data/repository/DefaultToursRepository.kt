package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.common.MessageResponseDto
import com.example.startup_mobile.data.dto.tours.TourCreateDto
import com.example.startup_mobile.data.dto.tours.TourUpdateDto
import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.remote.ToursApi
import com.example.startup_mobile.domain.Tour

class DefaultToursRepository(private val api: ToursApi) : ToursRepository {
    override suspend fun getMyTours(page: Int?, perPage: Int?): PaginatedResponse<Tour> {
        val response = api.getMyTours(page, perPage)
        return PaginatedResponse(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun createTour(body: TourCreateDto): Tour? = api.createTour(body)?.toDomain()

    override suspend fun getTour(id: Int): Tour? = api.getTour(id)?.toDomain()

    override suspend fun updateTour(id: Int, body: TourUpdateDto): Tour? =
        api.updateTour(id, body)?.toDomain()

    override suspend fun publishTour(id: Int): Tour? = api.publishTour(id)?.toDomain()

    override suspend fun archiveTour(id: Int): Tour? = api.archiveTour(id)?.toDomain()

    override suspend fun addTourImage(
        id: Int,
        fileBytes: ByteArray,
        fileName: String,
        isCover: Boolean?,
    ): Tour? = api.addTourImage(id, fileBytes, fileName, isCover)?.toDomain()

    override suspend fun deleteTourImage(tourId: Int, imageId: Int): MessageResponseDto? =
        api.deleteTourImage(tourId, imageId)
}
