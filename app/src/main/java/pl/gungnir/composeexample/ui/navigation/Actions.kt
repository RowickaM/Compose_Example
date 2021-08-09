package pl.gungnir.composeexample.ui.navigation

import androidx.navigation.NavController

class Actions(
    private val navController: NavController?
) {
    val navBack: () -> Unit = {
        navController?.navigateUp()
    }
    val navToSecond: () -> Unit = {
        navController?.navigate(
            NavigationItem.SecondScreen.route
        )
    }
    val navToDetails: (String) -> Unit = {
        val route = NavigationItem.DetailsScreen.route
        val routeWithArg = route.replace("{PARAM_ID}", it)
        navController?.navigate(routeWithArg)
    }
}