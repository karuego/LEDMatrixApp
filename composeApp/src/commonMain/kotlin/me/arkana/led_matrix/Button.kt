package me.arkana.led_matrix

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun btnNavigateBack(action: () -> Unit) {
    Box(Modifier.fillMaxSize().padding(bottom = 16.dp)) {
        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xffdc3545)
            ),
            onClick = action
        ) {
            Text("◀️ Kembali")
        }
    }
}

fun btnPindaiPerangkatOnClick(): Unit {
    
}
