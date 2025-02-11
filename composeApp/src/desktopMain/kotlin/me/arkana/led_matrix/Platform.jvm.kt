package me.arkana.led_matrix

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val domain = "desktop"
}

actual fun getPlatform(): Platform = JVMPlatform()
