package com.example.startup_mobile.data.remote

/**
 * Creates HttpClient with the given token provider (e.g. from [SessionRepository]).
 */
fun createDefaultHttpClient(tokenProvider: () -> String?): HttpClient = HttpClient(
    tokenProvider = tokenProvider,
)
