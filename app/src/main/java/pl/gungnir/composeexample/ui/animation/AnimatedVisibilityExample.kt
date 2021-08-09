package pl.gungnir.composeexample.ui.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun AnimatedVisibilityExample() {

    val (visible, setVisible) = remember { mutableStateOf(false) }
    val buttonTitle = if (visible) "Hide" else "Show"

    AnimationWrapper(
        title = "Animated Visibility",
        buttonTitle = buttonTitle,
        buttonAction = { setVisible(!visible) }
    ){
        AnimatedVisibility(
            visible = visible,
            enter = expandVertically(
                expandFrom = Alignment.Top,
                animationSpec = tween(durationMillis = 1500)
            ),
            exit = shrinkVertically(
                shrinkTowards = Alignment.Top,
                animationSpec = tween(durationMillis = 1500)
            )
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.LightGray)
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun AnimatedVisibilityExamplePreview() {
    AnimatedVisibilityExample()
}