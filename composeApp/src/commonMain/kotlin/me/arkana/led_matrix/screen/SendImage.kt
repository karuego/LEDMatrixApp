package me.arkana.led_matrix.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import me.arkana.led_matrix.btnNavigateBack
import me.arkana.led_matrix.txtTitle

@Composable
fun SendImageScreen(navController: NavController, name: String) {
    btnNavigateBack { navController.popBackStack() }

    Column(modifier = Modifier.padding(16.dp)) {
        txtTitle("Kirim Gambar")
        Text("Details Screen for $name")
        Spacer(modifier = Modifier.height(8.dp))

    }
}
