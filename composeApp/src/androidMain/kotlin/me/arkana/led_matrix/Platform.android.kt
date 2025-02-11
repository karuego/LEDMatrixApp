package me.arkana.led_matrix

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val domain = "mobile"
}

actual fun getPlatform(): Platform = AndroidPlatform()
