package com.example.moviles.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NumberTextFill(modificador : Modifier, fill : (String) -> Unit)
{
    var number by remember { mutableStateOf("") }
    Column(modifier = modificador.background(Color.LightGray)) {
        Text(text = "Ingresa otro numero")
        TextField(
            value = number,
            onValueChange = { textoEscrito ->
                if(textoEscrito.toIntOrNull() != null) {
                    number = textoEscrito.toInt().toString()
                    fill(number)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Preview
@Composable
fun NumberTextFillPreview()
{
    NumberTextFill(Modifier.fillMaxWidth()){

    }
}