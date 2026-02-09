package com.example.startup_mobile.platform

enum class LogLevel {
    VERBOSE, DEBUG, INFO, WARNING, ERROR
}

interface Logger {
    fun log(level: LogLevel, tag: String, message: String, throwable: Throwable? = null)
}

expect fun getLogger(): Logger
