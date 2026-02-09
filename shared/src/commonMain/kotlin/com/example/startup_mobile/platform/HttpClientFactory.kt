package com.example.startup_mobile.platform

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect fun createHttpClient(block: HttpClientConfig<*>.() -> Unit = {}): HttpClient
