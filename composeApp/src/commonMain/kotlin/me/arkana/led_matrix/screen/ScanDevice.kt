package me.arkana.led_matrix.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import me.arkana.led_matrix.NavigationEvent
import me.arkana.led_matrix.btnNavigateBack
import me.arkana.led_matrix.txtTitle

@Composable
fun ScanDeviceScreen(handleNavigation: (NavigationEvent) -> Unit) {
    btnNavigateBack {
        handleNavigation(NavigationEvent.OnBackPressed)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        txtTitle("Pindai Perangkat")

        /*Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Kembali")
        }*/
    }
}
