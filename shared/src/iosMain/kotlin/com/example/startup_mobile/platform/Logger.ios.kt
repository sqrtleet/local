package com.example.startup_mobile.platform

import platform.Foundation.NSLog

actual fun getLogger(): Logger = IosLogger()

internal class IosLogger : Logger {
    override fun log(level: LogLevel, tag: String, message: String, throwable: Throwable?) {
        val line = "[$tag] $message" + (throwable?.let { " | $it" } ?: "")
        NSLog("%@", line)
    }
}
