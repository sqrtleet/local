package com.example.startup_mobile.platform

/**
 * Дефолтные значения конфига (общий источник для Android и iOS).
 */
object DefaultConfig {
    const val BASE_URL_KEY = "base_url"
    const val baseUrl = "https://api.example.com/"
}

/**
 * Платформенный контекст приложения (пути, конфиг, контекст активности).
 */
interface PlatformContext {
    val baseUrl: String
    val isDebug: Boolean
}

expect fun getPlatformContext(): PlatformContext
