package com.example.startup_mobile

/**
 * Sample/debug only — platform name for template greeting, not part of business domain.
 */
interface Platform {
    val name: String
}

expect fun getPlatform(): Platform