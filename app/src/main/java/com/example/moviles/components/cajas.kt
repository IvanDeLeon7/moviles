package com.example.moviles.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Cajas() {
    CajaInterna(alineacion = Alignment.TopStart)
    CajaInterna(alineacion = Alignment.BottomEnd)
}


@Composable
fun CajaInterna(alineacion : Alignment ){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = alineacion
    ) {
        Box(modifier = Modifier.size(width = 200.dp, height = 200.dp)) {
            Text(text = "A", Modifier.background(Color.Blue).align(Alignment.Center))
            Text(text = "B", Modifier.background(Color.Red).align(Alignment.BottomEnd))
            Text(text = "C", Modifier.background(Color.Green).align(Alignment.BottomStart))
            Text(text = "D", Modifier.background(Color.Blue).align(Alignment.TopEnd))
            Text(text = "E", Modifier.background(Color.Red).align(Alignment.TopStart))
            Text(text = "F", Modifier.background(Color.Green).align(Alignment.TopCenter))
            Text(text = "G", Modifier.background(Color.Blue).align(Alignment.CenterEnd))
            Text(text = "I", Modifier.background(Color.Red).align(Alignment.CenterStart))
            Text(text = "J", Modifier.background(Color.Green).align(Alignment.BottomCenter))
        }
    }
}




