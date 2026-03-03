package com.example.moviles.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun PantallaGameOverPreview() {
    // Creamos un controlador de mentira y un nombre de prueba para la vista previa
    val navController = rememberNavController()
    PantallaGameOver(navController = navController, nombreUsuario = "")
}
@Composable
fun PantallaGameOver(navController: NavHostController, nombreUsuario: String){
    var nombreEscrito by remember { mutableStateOf(nombreUsuario) }
    Column(modifier = Modifier.fillMaxSize().background(color = Color(0xFFF5EDD5)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text("Game Over", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color(0xFF645746))
        Text("7000 points scored in 476 moves. 2 powerups used:", fontSize = 16.sp,color = Color(0xFF645746), modifier = Modifier.padding(bottom = 15.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 8.dp),horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(42.dp).background(color = Color(0xFFB4A797), RoundedCornerShape(8.dp)),contentAlignment = Alignment.Center){
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "flecha", tint = Color.White)
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Box(modifier = Modifier.size(42.dp).background(color = Color(0xFFB4A797), shape = RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center){
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "Share", tint = Color.White)
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Box(modifier = Modifier.size(350.dp).background(color = Color(0xFF918268), shape = RoundedCornerShape(15.dp)), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(2.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)) { //el padding es para que los cuadritos no toquen la orilla cafe
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Celdas(numero = "2", colorFondo = Color(0xFFFAEBD2), colorTexto = Color(0xFF4F3209))
                    Celdas(numero = "32", colorFondo = Color(0xFFFF6856), colorTexto = Color.White)
                    Celdas(numero = "2", colorFondo = Color(0xFFFFEDD4), colorTexto = Color(0xFF4F3209))
                    Celdas(numero = "4", colorFondo = Color(0xFFE7D49F), colorTexto = Color(0xFF4F3209)
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Celdas(numero = "4", colorFondo = Color(0xFFE7D49F), colorTexto = Color(0xFF4F3209))
                    Celdas(numero = "64", colorFondo = Color(0xFFEC4034), colorTexto = Color.White)
                    Celdas(numero = "4", colorFondo = Color(0xFFE7D49F), colorTexto = Color(0xFF4F3209))
                    Celdas(numero = "128", colorFondo = Color(0xFFECC03B), colorTexto = Color.White)
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Celdas(numero = "8", colorFondo = Color(0xFFEE8A6B), colorTexto = Color.White)
                    Celdas(numero = "256", colorFondo = Color(0xFFECC03B), colorTexto = Color.White)
                    Celdas(numero = "512", colorFondo = Color(0xFFECC03B), colorTexto = Color.White)
                    Celdas(numero = "8", colorFondo = Color(0xFFEE8A6B), colorTexto = Color.White)
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Celdas(numero = "4", colorFondo = Color(0xFFE7D49F), colorTexto = Color(0xFF4F3209))
                    Celdas(numero = "8", colorFondo = Color(0xFFEE8A6B), colorTexto = Color.White)
                    Celdas(numero = "2", colorFondo = Color(0xFFFFEED5), colorTexto = Color(0xFF4F3209))
                    Celdas(numero = "4", colorFondo = Color(0xFFE7D49F), colorTexto = Color(0xFF4F3209))
                }

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 17.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { },modifier = Modifier.weight(2f),colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF8F7A66),contentColor = Color.White),shape = RoundedCornerShape(12.dp)){
                Text(text = "Play Again")}
            OutlinedButton(onClick = {},modifier = Modifier.weight(2f), border = BorderStroke(2.dp, Color(0xFF8F7A66)), shape = RoundedCornerShape(12.dp)){
                Text("Undo", color = Color(0xFF8F7A66))
            }}
        TextField(value = nombreEscrito, onValueChange = { nombreEscrito = it }, label = { Text("Escribe tu nombre") },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            singleLine = true
        )

        Text(
            text = "$nombreEscrito sigue participando", fontSize = 18.sp, color = Color.Gray, modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun Celdas(numero: String,colorFondo: Color,colorTexto: Color){
    Box(modifier = Modifier.size(77.dp).background(color = colorFondo, shape = RoundedCornerShape(8.dp)),contentAlignment = Alignment.Center){
        Text(numero, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = colorTexto)
    }

}