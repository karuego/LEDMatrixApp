package me.arkana.led_matrix

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

expect fun logDebug(tag: String?, msg: String)

@Composable
expect fun getScreenWidth(): Dp

@Composable
expect fun getScreenHeight(): Dp
