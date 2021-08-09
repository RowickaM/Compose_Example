package pl.gungnir.composeexample.ui.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContentSizeExample() {
    val (size, setSize) = remember { mutableStateOf(Size(100F, 100F)) }

    AnimationWrapper(
        title = "Animate Content Size",
        buttonTitle = "Change size",
        buttonAction = {
            if(size.height == 100F){
                setSize(Size(150F, 150F))
            } else {
                setSize(Size(100F, 100F))
            }
        }
    ){
        Box(
            modifier = Modifier
                .animateContentSize(animationSpec = tween(1000))
                .size(size.height.dp)
                .background(Color.LightGray))
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimateContentSizeExamplePreview() {
    AnimateContentSizeExample()
}