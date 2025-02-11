package me.arkana.led_matrix.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button

import androidx.compose.material.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import ledmatrixapp.composeapp.generated.resources.Res
import ledmatrixapp.composeapp.generated.resources.compose_multiplatform

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

import me.arkana.led_matrix.Greeting
import me.arkana.led_matrix.Screen
import me.arkana.led_matrix.getPlatform

@Composable
fun HomeScreen(navController: NavHostController) {
    var showContent by remember { mutableStateOf(false) }
    var deviceTerpilih by remember { mutableStateOf("----") }

    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Halaman Utama", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        /*Button(onClick = { navigator.navigate("/details/JetpackCompose") }) {
            Text("Go to Details")
        }*/

        Row {
            Text("Device Terpilih: ")
            Text(deviceTerpilih)
        }
        Spacer(modifier = Modifier.height(12.dp))

        val btnToSettingsScreen = @Composable {
                Button(onClick = {
                    //navController.navigate("settings")
                    navController.navigate(Screen.Settings(
                        name = "Solanaceae",
                        age = 20
                    ))
                }) {
                    Text("Pengaturan")
                }
        }

        Row {
            Button(onClick = {
                showContent = !showContent
                //navController.navigate("send/text")
                navController.navigate(Screen.Send.Text)
            }) {
                Text("Kirim Teks")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = {
                //navController.navigate("send/image")
                navController.navigate(Screen.Send.Image)
            }) {
                Text("Kirim Gambar")
            }
            if (getPlatform().domain != "mobile") {
                Spacer(Modifier.width(8.dp))
                btnToSettingsScreen()
            }
        }

        if (getPlatform().domain == "mobile") {
            Spacer(Modifier.height(8.dp))
            btnToSettingsScreen()
        }

        Button(onClick = { navController.navigate(Screen.Send.Video) }) {
            Text("Send Video")
        }

        Box(Modifier.fillMaxSize().padding(bottom = 32.dp)) {
            Button(
                modifier = Modifier.align(Alignment.BottomCenter),
                onClick = {
                    //navController.navigate("scan")
                    navController.navigate(Screen.Scan)
                }
            ) {
                Text("Pindai Perangkat")
            }
        }

        AnimatedVisibility(showContent) {
            val greeting = remember { Greeting().greet() }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
        }
    }
}
