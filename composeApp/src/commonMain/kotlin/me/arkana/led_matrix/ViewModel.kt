package me.arkana.led_matrix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val _perangkatTerpilih = MutableStateFlow("----")
    val perangkatTerpilih: StateFlow<String> = _perangkatTerpilih

    fun pilihPerangkat(perangkat: String) {
        _perangkatTerpilih.value = perangkat
    }

    fun login(username: String, token: String) {
        // Create a new coroutine to move the execution off the UI thread
        // TODO: Gunakan Dispatchers.IO
        viewModelScope.launch(Dispatchers.Default) {
            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
            //loginRepository.makeLoginRequest(jsonBody)
        }
    }
}
