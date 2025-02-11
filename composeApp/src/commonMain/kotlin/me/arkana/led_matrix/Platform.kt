package me.arkana.led_matrix

interface Platform {
    val name: String
    val domain: String
}

expect fun getPlatform(): Platform
