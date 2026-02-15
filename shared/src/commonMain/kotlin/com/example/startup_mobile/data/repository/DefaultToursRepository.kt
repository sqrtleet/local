package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.data.remote.ToursApi
import com.example.startup_mobile.domain.CreateTourPayload
import com.example.startup_mobile.domain.MessageResult
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.Tour
import com.example.startup_mobile.domain.UpdateTourPayload
import com.example.startup_mobile.domain.repository.ToursRepository

class DefaultToursRepository(private val api: ToursApi) : ToursRepository {
    override suspend fun getMyTours(page: Int?, perPage: Int?): Page<Tour> {
        val response = api.getMyTours(page, perPage)
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun createTour(body: CreateTourPayload): Tour? =
        api.createTour(body.toDto())?.toDomain()

    override suspend fun getTour(id: Int): Tour? = api.getTour(id)?.toDomain()

    override suspend fun updateTour(id: Int, body: UpdateTourPayload): Tour? =
        api.updateTour(id, body.toDto())?.toDomain()

    override suspend fun publishTour(id: Int): Tour? = api.publishTour(id)?.toDomain()

    override suspend fun archiveTour(id: Int): Tour? = api.archiveTour(id)?.toDomain()

    override suspend fun addTourImage(
        id: Int,
        fileBytes: ByteArray,
        fileName: String,
        isCover: Boolean?,
    ): Tour? = api.addTourImage(id, fileBytes, fileName, isCover)?.toDomain()

    override suspend fun deleteTourImage(tourId: Int, imageId: Int): MessageResult? =
        api.deleteTourImage(tourId, imageId)?.toDomain()
}
