package me.arkana.led_matrix.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import me.arkana.led_matrix.MyViewModel
import me.arkana.led_matrix.NavigationEvent
import me.arkana.led_matrix.btnNavigateBack
import me.arkana.led_matrix.myViewModel
import me.arkana.led_matrix.txtTitle

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScanDeviceScreen(contentPadding: PaddingValues, handleNavigation: (NavigationEvent) -> Unit) {
    /*btnNavigateBack {
        handleNavigation(NavigationEvent.OnBackPressed)
    }*/

    //var perangkatTerpilih by remember { mutableStateOf("----") }
    val perangkatTerpilih by myViewModel.perangkatTerpilih.collectAsState()

    var screenWidth by remember { mutableStateOf(0.dp) }

    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        screenWidth = maxWidth
        //val boxHeight = maxHeight
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
    ) {
        txtTitle("Pindai Perangkat")
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        Text("Perangkat terpilih: $perangkatTerpilih")
        Spacer(modifier = Modifier.height(8.dp))

        val ini_angka = listOf("Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas", "Dua Belas", "Tiga Belas")
        var arr_angka by remember { mutableStateOf(ini_angka) }
        LazyColumn(
            modifier = Modifier.fillMaxSize().weight(1f),
            contentPadding = contentPadding
        ) {
            items(arr_angka) { angka ->
                ListItem(
                    modifier = Modifier.fillMaxWidth().clickable {
                        //perangkatTerpilih = angka
                        myViewModel.pilihPerangkat(angka)
                        //arr_angka = arr_angka.filter { it != angka }
                    }
                ) {
                    Text(angka)
                }
                Divider(modifier = Modifier.padding(horizontal = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xffdc3545)
                ),
                onClick = { handleNavigation(NavigationEvent.OnBackPressed) }
            ) {
                /*if (screenWidth <= 301.5.dp)
                    Text("◀️")
                else*/
                    Text("Kembali")
            }
            Spacer(modifier = Modifier.width(10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        myViewModel.pilihPerangkat("----")
                        //TODO refresh list
                        arr_angka = arr_angka.shuffled()
                    }
                ) {
                    /*if (screenWidth <= 301.5.dp)
                        Text("🔃")
                    else*/
                        Text("Refresh")
                }

                /*Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = {
                        //TODO: set perangkatTerpilih pada HomeScreen
                        handleNavigation(NavigationEvent.OnBackPressed)
                    }
                ) {
                        if (screenWidth <= 301.5.dp)
                            Text("✔️")
                        else
                            Text("Pilih")
                }*/
            }
        }
    }
}
