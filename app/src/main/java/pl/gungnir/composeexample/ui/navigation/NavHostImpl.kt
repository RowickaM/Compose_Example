package pl.gungnir.composeexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import pl.gungnir.composeexample.ui.navigation.screens.FirstScreen
import pl.gungnir.composeexample.ui.navigation.screens.DetailsScreen
import pl.gungnir.composeexample.ui.navigation.screens.SecondScreen

@Composable
fun NavHostImpl(
    navController: NavHostController,
    navToBack: () -> Unit,
    navToSecond: () -> Unit,
    navToDetails: (String) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.FirstScreen.route,
    ) {
        composable(
            route = NavigationItem.FirstScreen.route
        ) {
            FirstScreen( // komponent własny
                navToSecond = navToSecond
            )
        }
        composable(
            route = NavigationItem.SecondScreen.route
        ) {
            SecondScreen( // komponent własny
                navToBack = navToBack,
                navToDetails = navToDetails
            )
        }
        composable(
            route = NavigationItem.DetailsScreen.route,
            arguments = listOf(
                navArgument("PARAM_ID"){
                    type = NavType.StringType
                }
            )
        ) {
            val param = it.arguments?.getString("PARAM_ID")
            param?.let {
                DetailsScreen( // komponent własny
                    params = param
                )
            }
        }
    }
}