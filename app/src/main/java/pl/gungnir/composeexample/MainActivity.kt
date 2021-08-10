package pl.gungnir.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import pl.gungnir.composeexample.ui.animation.*
import pl.gungnir.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    AnimatedVisibilityExample()
                    Divider()
                    AnimatedContentExample()
                    Divider()
                    AnimateContentSizeExample()
                    Divider()
                    CrossfadeExample()
                    Divider()
                    AnimatedAsStateExample()
                    Divider()
                    UpdateTransitionExample()
                    Divider()
                    FoodAnimation()
                }

            }
        }
    }
}

@Composable
fun ConstraintLayoutExample1() {
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
    ) {
        val button = createRef()
        val text = createRef()

        Button(
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(parent.top, margin = 12.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                },
            onClick = {}
        ) {
            Text(text = "Button")
        }

        Text(
            modifier = Modifier
                .constrainAs(text) {
                    baseline.linkTo(button.baseline)
                    start.linkTo(button.end, margin = 12.dp)
                },
            text = "Text"
        )
    }
}

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth(),
        constraintSet = decoupledConstraints()
    ) {
        Button(
            modifier = Modifier.layoutId("buttonID"),
            onClick = {}
        ) {
            Text(text = "Button")
        }

        Text(
            modifier = Modifier.layoutId("textID"),
            text = "Text"
        )
    }
}

private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("buttonID")
        val text = createRefFor("textID")

        constrain(button) {
            top.linkTo(parent.top, margin = 12.dp)
            start.linkTo(parent.start, margin = 12.dp)
        }
        constrain(text) {
            baseline.linkTo(button.baseline)
            start.linkTo(button.end, margin = 12.dp)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ConstraintLayoutExamplePreview() {
    Column {
//        ConstraintLayoutExample1()
        ConstraintLayoutExample()
    }

}