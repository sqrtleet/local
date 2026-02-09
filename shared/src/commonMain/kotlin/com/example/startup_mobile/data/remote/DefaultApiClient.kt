package com.example.startup_mobile.data.remote

import com.example.startup_mobile.platform.getKeyValueStorage

private const val KEY_TOKEN = "auth_token"

fun createDefaultHttpClient(): HttpClient = HttpClient(
    tokenProvider = { getKeyValueStorage().getString(KEY_TOKEN) }
)
