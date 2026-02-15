package com.example.startup_mobile.domain

/**
 * Domain-level pagination result. Not tied to serialization.
 */
data class Page<T>(
    val items: List<T>,
    val total: Int,
    val page: Int,
    val perPage: Int,
    val pages: Int,
)
