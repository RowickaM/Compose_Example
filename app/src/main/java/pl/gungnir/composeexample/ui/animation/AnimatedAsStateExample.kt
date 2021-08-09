package pl.gungnir.composeexample.ui.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedAsStateExample() {

    val (animated, setAnimatedState) = remember { mutableStateOf(false) }
    val color by animateColorAsState(targetValue = if (animated) Color.LightGray else Color.Green, animationSpec = tween(1000) )

    AnimationWrapper(
        title = "Animated * As State",
        buttonTitle = "Change",
        buttonAction = { setAnimatedState(!animated) }
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(color)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimatedAsStateExamplePreview() {
    AnimatedAsStateExample()
}