package pl.gungnir.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import pl.gungnir.composeexample.ui.navigation.Actions
import pl.gungnir.composeexample.ui.navigation.NavHostImpl

class NavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val actions = Actions(navController)

            NavHostImpl(
                navController = navController,
                navToBack = actions.navBack,
                navToSecond = actions.navToSecond,
                navToDetails = actions.navToDetails
            )
        }
    }
}