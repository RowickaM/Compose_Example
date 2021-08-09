package pl.gungnir.composeexample.ui.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UpdateTransitionExample() {

    val (state, setState) = remember { mutableStateOf(BoxState.START) }
    val transition = updateTransition(targetState = state, label = "transition")

    val color by transition.animateColor(
        label = "transition color",
        transitionSpec = { tween(durationMillis = 1000) }
    ) {
        when(it){
            BoxState.START -> Color.LightGray
            BoxState.END -> Color.Green
        }
    }

    val angle by transition.animateFloat(
        label = "transition rotation",
        transitionSpec = { tween(durationMillis = 1000) }
    ) {
        when(it){
            BoxState.START -> 0F
            BoxState.END -> 360F
        }
    }

    AnimationWrapper(
        title = "Update Transition",
        buttonTitle = "Change",
        buttonAction = { setState(if (state == BoxState.START) BoxState.END else BoxState.START) }
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .rotate(angle)
                .background(color)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UpdateTransitionExamplePreview() {
    UpdateTransitionExample()
}

private enum class BoxState {
    START,
    END
}