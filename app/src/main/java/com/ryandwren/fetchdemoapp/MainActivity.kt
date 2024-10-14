package com.ryandwren.fetchdemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ryandwren.fetchdemoapp.ui.MainScreen
import com.ryandwren.fetchdemoapp.ui.MainScreenViewModel
import com.ryandwren.fetchdemoapp.ui.theme.FetchDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchDemoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = hiltViewModel<MainScreenViewModel>()

                    MainScreen(
                        state = viewModel.state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}