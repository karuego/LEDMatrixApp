package me.arkana.led_matrix

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

actual fun logDebug(tag: String?, msg: String) {
    Log.d(tag, msg)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MUSL", "Mulai")
        setContent {
            App()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppAndroidPreview() {
    App()
}
