package com.example.moviles.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Columnas() {
    Column(verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hola", modifier = Modifier.fillMaxSize() )
        HorizontalDivider( thickness = 20.dp)
        Text(text = "Adios", modifier = Modifier.fillMaxSize())
        Text(text = "Hola", modifier = Modifier.fillMaxSize())
    }
}
