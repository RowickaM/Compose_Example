package pl.gungnir.composeexample.ui.navigation

sealed class NavigationItem (val route: String){
    object FirstScreen : NavigationItem("first")
    object SecondScreen : NavigationItem("second")
    object DetailsScreen : NavigationItem("second/{PARAM_ID}")
}