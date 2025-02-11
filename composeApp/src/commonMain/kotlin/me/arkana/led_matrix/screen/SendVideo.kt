package me.arkana.led_matrix.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ledmatrixapp.composeapp.generated.resources.Res
import ledmatrixapp.composeapp.generated.resources.compose_multiplatform
import me.arkana.led_matrix.Greeting
import org.jetbrains.compose.resources.painterResource

@Composable
fun SendVideoScreen(navController: NavController) {
    var showContent by remember { mutableStateOf(false) }

    Box {
        Box(Modifier.fillMaxSize().background(Color.Cyan))
        Box(Modifier.matchParentSize().padding(top = 20.dp, bottom = 20.dp).background(Color.Yellow))
        Box(Modifier.matchParentSize().padding(40.dp).background(Color. Magenta))
        Box(
            Modifier.align(Alignment.Center).size(300.dp, 300.dp).background(Color.Green).padding(30.dp),
            Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.Red).padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("⚠️Under construction", color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    modifier = Modifier.background(Color.Blue),
                    onClick = { /*showContent = !showContent*/ navController.popBackStack() }) {
                    Text("Kembali")
                }
            }
        }
        Box(Modifier.align(Alignment.TopStart).size(150.dp, 150.dp).background(Color.Red))
        Box(Modifier.align(Alignment.BottomEnd).size(150.dp, 150.dp).background(Color.Blue))
    }

    /*Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.Red).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("⚠️Under construction", color = Color.White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Kembali")
        }
    }*/

    AnimatedVisibility(showContent) {
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(Res.drawable.compose_multiplatform), null)
            Text("Compose: $greeting")
        }
    }
}
