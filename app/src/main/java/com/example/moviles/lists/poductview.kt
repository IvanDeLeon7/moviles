package com.example.moviles.lists
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles.R


@Preview(showBackground = true)
@Composable
fun ProductPreview(){
    val product = ProductModel(imageProduct = R.drawable.mac, nombre = "Macbook",  precio = 2000.0)
    ProductView(product)

}

@Composable
fun ProductView( product : ProductModel){
    Card(modifier = Modifier.fillMaxWidth().padding(10.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row() {
                Image(painter = painterResource(id = product.imageProduct),
                    contentDescription = "imagen de producto",
                    modifier = Modifier.size(120.dp).align(Alignment.CenterVertically)
                )
                Column(modifier = Modifier.padding(5.dp)) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Text("${product.nombre}", fontSize = 20.sp)
                    Text("?4.8 estrellas", fontSize = 17.sp)
                    Text("{${product.precio}", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text("Llega el viernes")
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Black)) {Text("Agregar al carrito")
                    }
                    Spacer(modifier = Modifier.size(10.dp))

                }
            }
        }
    }

}
