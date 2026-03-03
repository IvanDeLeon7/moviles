package com.example.moviles.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable

fun ListView(){
    val productVM = ProductViewModel()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        LazyColumn() {
            items(productVM.getProducts()){product ->
                ProductView(product)
                
            }
        }

    }
}