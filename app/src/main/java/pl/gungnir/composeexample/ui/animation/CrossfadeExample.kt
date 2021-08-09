package pl.gungnir.composeexample.ui.animation

import androidx.compose.animation.Crossfade
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CrossfadeExample() {
    val (initial, setInitial) = remember { mutableStateOf("A") }

    AnimationWrapper(
        title = "Crossfade",
        buttonTitle = "Change",
        buttonAction = { setInitial(if (initial == "A") "B" else "A") }
    ) {
        Crossfade(targetState = initial) { screen ->
            when (screen) {
                "A" -> Text("Page A")
                "B" -> Text("Page B")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun CrossfadeExamplePreview() {
    CrossfadeExample()
}