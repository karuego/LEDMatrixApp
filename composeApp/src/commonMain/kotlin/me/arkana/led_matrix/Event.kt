package me.arkana.led_matrix

import androidx.navigation.NavController

sealed class NavigationEvent {
    data object OnBackPressed : NavigationEvent()

}

fun handleNavigation(event: NavigationEvent, navController: NavController) {
    when (event) {
        //is NavigationEvent.OnCategoryClick -> navController.navigate(JobCategory(categoryName = event.categoryName))

        is NavigationEvent.OnBackPressed -> navController.popBackStack()

        //NavigationEvent.OnApplyNowClick -> navController.navigate(JobEligibility)
    }
}
