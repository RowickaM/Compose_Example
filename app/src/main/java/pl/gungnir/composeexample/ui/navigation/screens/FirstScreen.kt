package pl.gungnir.composeexample.ui.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(
    navToSecond: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ekran nr 1", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navToSecond() }) {
            Text(text = "Do następnego ekranu")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FirstScreenPreview() {
    FirstScreen(
        navToSecond = {}
    )
}