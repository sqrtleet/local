package com.example.startup_mobile.domain

data class Media(
    val id: String,
    val url: String,
    val type: MediaType,
    val thumbnailUrl: String?,
)

enum class MediaType {
    PHOTO,
    VIDEO,
}
