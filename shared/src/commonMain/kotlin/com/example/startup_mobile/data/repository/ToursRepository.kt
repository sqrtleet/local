package com.example.startup_mobile.data.repository

import com.example.startup_mobile.domain.Tour

interface ToursRepository {
    suspend fun getTours(): List<Tour>
    suspend fun getTour(id: String): Tour?
}
