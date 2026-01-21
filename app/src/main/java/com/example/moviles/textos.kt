package com.example.moviles
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable

fun MyTextView(){
    Text(text = "Y DALE DALE BOCA",
    color = Color.Blue,
        fontSize = 80.sp,
    fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 20.sp,
        maxLines = 2,


    )

}

fun suma(a: Int, b: Int): Int {
    return a + b
}


