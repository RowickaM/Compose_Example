package pl.gungnir.composeexample.ui.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AnimationWrapper(
    title: String,
    buttonTitle: String,
    buttonAction: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier = Modifier.animateContentSize(),
            onClick = buttonAction
        ) {
            Text(text = buttonTitle)
        }
        Spacer(modifier = Modifier.height(16.dp))
        content()
    }
}

@Composable
fun Divider() {
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(horizontal = 16.dp)
                .background(color = Color(0xB3696969))
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}