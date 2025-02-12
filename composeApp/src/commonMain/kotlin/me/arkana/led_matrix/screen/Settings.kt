package me.arkana.led_matrix.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import me.arkana.led_matrix.Screen
import me.arkana.led_matrix.btnNavigateBack
import me.arkana.led_matrix.txtTitle

@Composable
fun SettingsScreen(navController: NavController, args: Screen.Settings) {
    btnNavigateBack { navController.popBackStack() }

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp)) {
        txtTitle("Pengaturan")

        Spacer(modifier = Modifier.height(8.dp))
        Text("${args.name}, ${args.age} years old")

        Button(
            onClick = {
                scope.launch {
                    prefs
                }
            }
        )
    }
}
