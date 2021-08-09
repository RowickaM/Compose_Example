package pl.gungnir.composeexample.ui.screens

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
fun SecondScreen(
    navToBack: () -> Unit,
    navToDetails: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ekran nr 2", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navToBack() }) {
            Text(text = "Do poprzedniego ekranu")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navToDetails("dane z poprzedniego ekranu") }) {
            Text(text = "Do ekranu szczegółów")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SecondScreenPreview() {
    SecondScreen(navToBack = {}, navToDetails = {})
}