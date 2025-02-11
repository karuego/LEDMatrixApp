package me.arkana.led_matrix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    fun login(username: String, token: String) {
        // Create a new coroutine to move the execution off the UI thread
        // TODO: Gunakan Dispatchers.IO
        viewModelScope.launch(Dispatchers.Default) {
            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
            //loginRepository.makeLoginRequest(jsonBody)
        }
    }
}
