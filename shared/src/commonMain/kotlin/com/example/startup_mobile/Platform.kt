package com.example.startup_mobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform