package com.ryandwren.fetchdemoapp.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ryandwren.fetchdemoapp.ui.theme.FetchDemoAppTheme

@Composable
fun MainScreen(state: MainScreenState, modifier: Modifier){
    Text(
        text = "Hello!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FetchDemoAppTheme {
        MainScreen(state = MainScreenState(), modifier = Modifier)
    }
}