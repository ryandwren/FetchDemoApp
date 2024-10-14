package com.ryandwren.fetchdemoapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryandwren.fetchdemoapp.data.HireItem
import com.ryandwren.fetchdemoapp.ui.theme.FetchDemoAppTheme

@Composable
fun MainScreen(state: MainScreenState, modifier: Modifier) {
    Box(modifier = modifier) {
        if (state.hireList.value.isNotEmpty()) {
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 24.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "List ID")
                        Text(text = "Name")
                        Text(text = "Item ID")
                    }
                }

                for (hireItem in state.hireList.value) {
                    item {
                        ItemCard(item = hireItem)
                    }
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 30.dp)
                ) {
                    if (state.isRequestInProgress.value) {
                        CircularProgressIndicator()
                    } else {
                        Text(text = "No items found")
                    }
                }
            }
        }
    }
}

@Composable
fun ItemCard(item: HireItem) {
    var backgroundColor = Color.White
    when(item.listId){
        1 -> backgroundColor = Color(0x5F6298f0)
        2 -> backgroundColor = Color(0x5Ff0e278)
        3 -> backgroundColor = Color(0x5Fff6961)
        4 -> backgroundColor = Color(0x5F88ff7d)
    }

    Row(
        modifier = Modifier
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item.listId.toString())
        Text(text = item.name.toString())
        Text(text = item.id.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FetchDemoAppTheme {
        MainScreen(
            state = MainScreenState().apply {
                hireList.value = listOf(
                    HireItem(1,1,"Item 1"),
                    HireItem(2,1,"Item 2"),
                    HireItem(3,1,"Item 3"),
                    HireItem(4,1,"Item 4"),
                    HireItem(1,2,"Item 1"),
                    HireItem(2,2,"Item 2"),
                    HireItem(3,2,"Item 3"),
                    HireItem(4,2,"Item 4"),
                )
            },
            modifier = Modifier
        )
    }
}