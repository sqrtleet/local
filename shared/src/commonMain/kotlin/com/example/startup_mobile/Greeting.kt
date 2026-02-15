package com.example.startup_mobile

/**
 * Sample/debug only — KMP template placeholder, not part of business domain.
 * Safe to remove or replace when building production UI.
 */
class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}