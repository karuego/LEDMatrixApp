package me.arkana.led_matrix

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() {
    val prefs = createDataStore {
        DATASTORE_FILENAME
    }
    application {
        val windowState = rememberWindowState()
        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "LEDMatrixApp",
        ) {
            App(
                prefs = prefs
            )
        }
    }
}

actual fun logDebug(tag: String?, msg: String) {
    println("$tag: $msg")
}
