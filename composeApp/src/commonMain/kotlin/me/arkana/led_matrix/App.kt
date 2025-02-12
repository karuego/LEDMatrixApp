package me.arkana.led_matrix

import androidx.compose.animation.core.tween

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

import kotlinx.serialization.Serializable

import me.arkana.led_matrix.screen.*

val myViewModel = MyViewModel()

@Composable
fun App(
    prefs: DataStore<Preferences>
) = MaterialTheme(
    lightColors(
        primary = Color(0xff0d6efd),
        secondary = Color(0xff6c757d),
        error = Color(0xffdc3545),
    )
) {
    //val myViewModel = MyViewModel()
    val navController = rememberNavController()

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = backStackEntry?.destination?.route

    val scope = rememberCoroutineScope()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home,
        ) {
            composable<Screen.Home>(
                exitTransition = {
                    if (
                        targetState.destination.hasRoute<Screen.Settings>() or
                        targetState.destination.hasRoute<Screen.Scan>()
                    ) {
                        //fadeOut() + shrinkVertically()
                        slideOutVertically(tween(700)) { it * 3 }
                    } else if (targetState.destination.hasRoute<Screen.Settings>()) {
                        fadeOut(tween(700))
                    } else if (targetState.destination.hasRoute<Screen.Send.Video>()) {
                        slideOutHorizontally(tween(700)) { it }
                    } else {
                        slideOutHorizontally(tween(500)) { it }
                    }
                },
                popEnterTransition = {
                    if (initialState.destination.hasRoute<Screen.Scan>()) {
                        slideInVertically { it * 3 }
                    } else if (initialState.destination.hasRoute<Screen.Settings>()) {
                        slideInVertically { -it }
                    } else if (initialState.destination.hasRoute<Screen.Send.Text>()) {
                        slideInHorizontally(tween(700)) { -it }
                    } else if (initialState.destination.hasRoute<Screen.Send.Video>()) {
                        slideInVertically(tween(700)) { -it }
                    } else {
                        slideInHorizontally(tween(700)) { it }
                    }
                },
            ) {
                HomeScreen(navController)
            }

            composable<Screen.Settings>(
                enterTransition = { fadeIn() + expandVertically() },
                exitTransition = { shrinkHorizontally(tween(700)) },
            ) {
                val args = it.toRoute<Screen.Settings>()
                SettingsScreen(
                    navController = navController,
                    args = args
                )
            }

            /*composable(
                "scan",*/
            composable<Screen.Scan>(
                //enterTransition = { fadeIn() + expandHorizontally() },
                enterTransition = { slideInVertically(tween(700)) { -it } },
                exitTransition = { slideOutVertically(tween(700)) { -it } + fadeOut(tween(700)) },
            ) {
                ScanDeviceScreen(contentPadding = innerPadding) {
                    handleNavigation(it, navController)
                }
            }

            sendGraph(navController)
        }
    }
}

fun NavGraphBuilder.sendGraph(navController: NavController) {
    navigation<SendGraph>(startDestination = Screen.Send.Text) {
        //composable("send/text") {
        composable<Screen.Send.Text>(
            enterTransition = { slideInVertically { -it } },
            exitTransition = { slideOutVertically(tween(700)) { -it } + fadeOut(tween(500)) }
        ) {
            SendTextScreen(
                navController = navController,
                name = "Halo"
            )
        }

        /*composable(
        "send/image",*/
        composable<Screen.Send.Image>(
            enterTransition = { slideInHorizontally(tween(700)) { -it } },
            exitTransition = { slideOutHorizontally(tween(700)) { -it } }
        ) {
            SendImageScreen(
                navController = navController,
                name = "Hai"
            )
        }

        composable<Screen.Send.Video>(
            //enterTransition = { slideInHorizontally(tween(700)) { -it } },
            enterTransition = { expandIn(tween(700)) },
            exitTransition = { fadeOut(tween(700)) + slideOutVertically(tween(700)) { it } }
        ) {
            SendVideoScreen(navController)
        }
    }
}

@Serializable
object SendGraph

@Serializable
sealed class Screen(val route: String) {
    @Serializable
    data object Home : Screen("home")

    @Serializable
    data class Settings(val name: String, val age: Int) : Screen("settings") /*{
        fun createRoute(itemId: Int) = "detail/$itemId"
    }*/

    @Serializable
    data object Scan : Screen("scan")

    @Serializable
    sealed class Send(val subroute: String) : Screen("send/${subroute}") {
        @Serializable data object Text : Send("text")
        @Serializable data object Image : Send("image")
        @Serializable data object Video : Send("video")
    }
}
