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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController

import me.arkana.led_matrix.Greeting
import me.arkana.led_matrix.Screen
import me.arkana.led_matrix.getPlatform
import me.arkana.led_matrix.myViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    var screenWidth by remember { mutableStateOf(0.dp) }
    var screenHeight by remember { mutableStateOf(0.dp) }
    val scrollState = rememberScrollState()

    var showContent by remember { mutableStateOf(false) }
    val perangkatTerpilih by myViewModel.perangkatTerpilih.collectAsState()

    BoxWithConstraints(modifier = Modifier.fillMaxSize().zIndex(1f)) {
        screenWidth = maxWidth
        screenHeight = maxHeight
    }

    Column(
        modifier = Modifier.verticalScroll(scrollState).padding(16.dp).fillMaxWidth().zIndex(9f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Halaman Utama", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        /*Button(onClick = { navigator.navigate("/details/JetpackCompose") }) {
            Text("Go to Details")
        }*/

        Row {
            Text("Device Terpilih: ")
            Text(perangkatTerpilih)
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

            if (screenWidth >= 410.dp) {
                Spacer(Modifier.width(8.dp))
                btnToSettingsScreen()
            }
        }

        if (screenWidth <= 410.dp) {
            Spacer(Modifier.height(8.dp))
            btnToSettingsScreen()
        }

        Button(onClick = { navController.navigate(Screen.Send.Video) }) {
            Text("Send Video")
        }

        if (screenHeight > 236.dp) {
            Spacer(Modifier.height(screenHeight - 300.dp))
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
