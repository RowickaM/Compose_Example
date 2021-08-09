package pl.gungnir.composeexample.ui.animation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalAnimationApi
@Composable
fun AnimatedContentExample() {

    val (count, setCount) = remember { mutableStateOf(0) }

    AnimationWrapper(
        title = "Animated Content",
        buttonTitle = "Add",
        buttonAction = { setCount(count + 1) }
    ) {
        Button(onClick = { setCount(count - 1) }) {
            Text(text = "Subtract")
        }
        Spacer(modifier = Modifier.height(8.dp))
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInHorizontally({ width -> width }) with slideOutHorizontally({ width -> -width })
                } else {
                    slideInHorizontally({ width -> -width }) with slideOutHorizontally({ width -> width })
                }
            }
        ) { targetCount ->
            // Make sure to use `targetCount`, not `count`.
            Text(text = "Count: $targetCount", fontSize = 20.sp)
        }

    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun AnimatedContentExamplePreview() {
    AnimatedContentExample()
}