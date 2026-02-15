package com.example.startup_mobile.domain

enum class RequestStatus {
    ACTIVE,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED,
    EXPIRED,
}

enum class OfferStatus {
    PENDING,
    ACCEPTED,
    DECLINED,
    WITHDRAWN,
    EXPIRED,
}
