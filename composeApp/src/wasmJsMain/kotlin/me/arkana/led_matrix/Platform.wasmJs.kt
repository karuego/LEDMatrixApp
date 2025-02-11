package me.arkana.led_matrix

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val domain = "web"
}

actual fun getPlatform(): Platform = WasmPlatform()
