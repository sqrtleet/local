package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.remote.ToursApi
import com.example.startup_mobile.domain.Tour

class DefaultToursRepository(private val api: ToursApi) : ToursRepository {
    override suspend fun getTours(): List<Tour> = api.getTours().map { it.toDomain() }
    override suspend fun getTour(id: String): Tour? = api.getTour(id)?.toDomain()
}
