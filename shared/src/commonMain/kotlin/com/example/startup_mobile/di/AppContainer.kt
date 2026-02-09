package com.example.startup_mobile.di

import com.example.startup_mobile.data.remote.AuthApi
import com.example.startup_mobile.data.remote.BookingsApi
import com.example.startup_mobile.data.remote.DefaultAuthApi
import com.example.startup_mobile.data.remote.DefaultBookingsApi
import com.example.startup_mobile.data.remote.DefaultProvidersApi
import com.example.startup_mobile.data.remote.DefaultToursApi
import com.example.startup_mobile.data.remote.HttpClient
import com.example.startup_mobile.data.remote.ProvidersApi
import com.example.startup_mobile.data.remote.ToursApi
import com.example.startup_mobile.data.repository.AuthRepository
import com.example.startup_mobile.data.repository.BookingsRepository
import com.example.startup_mobile.data.repository.DefaultAuthRepository
import com.example.startup_mobile.data.repository.DefaultBookingsRepository
import com.example.startup_mobile.data.repository.DefaultProvidersRepository
import com.example.startup_mobile.data.repository.DefaultToursRepository
import com.example.startup_mobile.data.repository.ProvidersRepository
import com.example.startup_mobile.data.repository.ToursRepository
import com.example.startup_mobile.data.remote.createDefaultHttpClient

/**
 * Single place that builds HttpClient → *Api → repositories.
 * Use [providersRepository], [toursRepository], [bookingsRepository], [authRepository] in UI/ViewModels.
 */
object AppContainer {
    private val httpClient: HttpClient by lazy { createDefaultHttpClient() }

    private val providersApi: ProvidersApi by lazy { DefaultProvidersApi(httpClient) }
    private val toursApi: ToursApi by lazy { DefaultToursApi(httpClient) }
    private val bookingsApi: BookingsApi by lazy { DefaultBookingsApi(httpClient) }
    private val authApi: AuthApi by lazy { DefaultAuthApi(httpClient) }

    val providersRepository: ProvidersRepository by lazy { DefaultProvidersRepository(providersApi) }
    val toursRepository: ToursRepository by lazy { DefaultToursRepository(toursApi) }
    val bookingsRepository: BookingsRepository by lazy { DefaultBookingsRepository(bookingsApi) }
    val authRepository: AuthRepository by lazy { DefaultAuthRepository(authApi) }
}
