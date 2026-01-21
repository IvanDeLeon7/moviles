package com.example.moviles.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Modificador() {
    Text(
        text = "Hola mundo",
        modifier = Modifier.padding(all = 7.dp).alpha(alpha = 0.5f),
        color=Color.Black,
    fontSize= 12.sp
    )

}