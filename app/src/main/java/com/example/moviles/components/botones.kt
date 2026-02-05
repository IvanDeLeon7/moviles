package com.example.moviles.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun Botones() {

    var activo by remember { mutableStateOf(false) }
    var texto by remember { mutableStateOf("adio") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = texto)

        Button(
            onClick = {
                texto = if (activo) "adio" else "hola"
                activo = !activo
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(text = "Cambiar")
        }
    }
}
