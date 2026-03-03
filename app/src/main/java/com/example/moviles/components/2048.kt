package com.example.a2048game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlin.compareTo
import kotlin.toString

@Preview (showBackground = true)
@Composable
fun PantallajuegoPreview() {
    val navController = rememberNavController()
    Pantallajuego(navController = navController)
}
@Composable
fun Pantallajuego(navController: NavHostController) {
    var tablero by remember { mutableStateOf(List(16) { 0 }) }
    var nombreUsuario by remember { mutableStateOf("") }
    val mejorFicha = tablero.maxOrNull() ?: 0

    LaunchedEffect(mejorFicha) {
        if (mejorFicha >= 2048) {
            navController.navigate("game_over_screen/$nombreUsuario")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5EDD5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Flecha", modifier = Modifier.size(30.dp), tint = Color(0xFF442B05)
            )
            Text("2048", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color(0xFF645746))
            Icon(
                imageVector = Icons.Default.Refresh, contentDescription = "Flecha", modifier = Modifier.size(30.dp).clickable { tablero = List(16) { 0 } }, tint = Color(0xFF442B05)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { }, modifier = Modifier.weight(2f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCBBCA7), contentColor = Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("SCORE", fontSize = 12.sp, color = Color.White)
                    Text("${tablero.sum()}", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
            OutlinedButton(onClick = {}, modifier = Modifier.weight(2f), border = BorderStroke(2.dp, Color(0xFF8F7A66)), shape = RoundedCornerShape(12.dp))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("BEST", fontSize = 12.sp, color = Color(0xFF8F7A66))
                    Text("${tablero.maxOrNull() ?: 0}", fontWeight = FontWeight.Bold, color = Color(0xFF8F7A66))
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.size(350.dp).background(color = Color(0xFF918268), shape = RoundedCornerShape(15.dp)),
            contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                tablero.chunked(4).forEachIndexed { rowIndex, fila ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        fila.forEachIndexed { colIndex, valor ->
                            val posicion = rowIndex * 4 + colIndex
                            Celdas(numero = valor, onClick = {
                                val nuevaLista = tablero.toMutableList()
                                if (nuevaLista[posicion] == 0) nuevaLista[posicion] = 2
                                else if (nuevaLista[posicion] < 2048) nuevaLista[posicion] *= 2

                                if (nuevaLista[posicion] >= 2048) {navController.navigate("game_over_screen/$nombreUsuario")
                                }
                                tablero = nuevaLista
                            }
                            )


                        }
                    }

                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.height(90.dp).width(230.dp).background(color = Color(0xFFE5D3C7), RoundedCornerShape(25.dp))
                .padding(12.dp), contentAlignment = Alignment.Center
        )
        {
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp))
                {
                    Box(modifier = Modifier.size(48.dp).background(color = Color(0xFFC5B6AB), shape = RoundedCornerShape(12.dp)).clickable{navController.popBackStack()}, contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { navController.navigate("actividad01")}){
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Flecha", modifier = Modifier.size(30.dp), tint = Color.White)
                        }
                    }
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp))
                {
                    Box(modifier = Modifier.size(48.dp).background(color = Color(0xFFC5B6AB), shape = RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = {navController.navigate("game_over_screen/$nombreUsuario")}) {
                            Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Circulo", modifier = Modifier.size(30.dp), tint = Color.White)
                        }
                    }
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)
                )
                {
                    Box(
                        modifier = Modifier.size(48.dp).background(color = Color(0xFFEADED8), shape = RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Puerta", modifier = Modifier.size(30.dp), tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Celdas(numero: Int, onClick: () -> Unit) {
    Box(modifier = Modifier.size(77.dp).background(cuandoNumero(numero), RoundedCornerShape(8.dp)).clickable { onClick() },contentAlignment = Alignment.Center) {
        Text(text = if (numero == 0) "" else numero.toString(), fontSize = 30.sp, fontWeight = FontWeight.Bold, color = if (numero <= 4) Color(0xFF776E65) else Color.White)
    }
}

fun cuandoNumero(numero: Int): Color {
    return when (numero) {
        0 -> Color(0xFFCDC1B4)
        2 -> Color(0xFFEEE4DA)
        4 -> Color(0xFFEDE0C8)
        8 -> Color(0xFFF2B179)
        16 -> Color(0xFFF59563)
        32 -> Color(0xFFF67C5F)
        64 -> Color(0xFFF65E3B)
        128 -> Color(0xFFEDCF72)
        256 -> Color(0xFFEDCC61)
        512 -> Color(0xFFEDC850)
        1024 -> Color(0xFFEDC53F)
        2048 -> Color(0xFFEDC22E)
        else -> Color(0xFF3C3A32)
    }
}







