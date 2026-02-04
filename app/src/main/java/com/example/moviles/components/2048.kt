package com.example.moviles.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles.R

val Background = Color(0xFFFAF8EF)
val TileEmpty = Color(0xFFCDC1B4)
val TileBorder = Color(0xFFBBADA0)

@Composable
fun Game2048Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(R.drawable.menu), contentDescription = null, modifier = Modifier.size(32.dp))
            Text("2048", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Icon(painter = painterResource(R.drawable.update), contentDescription = null, modifier = Modifier.size(32.dp))
        }

        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ScoreBox("SCORE", "1692")
            ScoreBox("BEST", "7000")
        }

        Spacer(Modifier.height(16.dp))
        GameBoard()

        Spacer(Modifier.height(24.dp))
        ControlButtons()
    }
}

@Composable
fun ScoreBox(title: String, value: String) {
    Column(
        modifier = Modifier
            .background(Color(0xFFEDE7DD), RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(title, fontSize = 12.sp, color = Color.Gray)
        Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun GameBoard() {
    Column(
        modifier = Modifier
            .background(TileBorder, RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(4) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(4) {
                    Tile(value = listOf(4, 32, 8, 16, 64, 128).random())
                }
            }
        }
    }
}

@Composable
fun Tile(value: Int?) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(TileColor(value), RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        if (value != null)
            Text(
                text = value.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
    }
}

fun TileColor(value: Int?): Color = when (value) {
    2 -> Color(0xFFEEE4DA)
    4 -> Color(0xFFEDE0C8)
    8 -> Color(0xFFF2B179)
    16 -> Color(0xFFF59563)
    32 -> Color(0xFFF67C5F)
    64 -> Color(0xFFF65E3B)
    128 -> Color(0xFFEDCF72)
    else -> TileEmpty
}
@Composable
fun ControlButtons() {
    Row(
        modifier = Modifier
            .background(Color(0xFFEDE7DD), RoundedCornerShape(16.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Icon(painter = painterResource(R.drawable.returnicon), contentDescription = null, modifier = Modifier.size(32.dp))
        Icon(painter = painterResource(R.drawable.squares), contentDescription = null, modifier = Modifier.size(32.dp))
        Icon(painter = painterResource(R.drawable.swap), contentDescription = null, modifier = Modifier.size(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GameOverScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Game Over", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(8.dp))

        Text(
            "7000 points scored in 476 moves.\n2 powerups used:",
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Icon(painter = painterResource(R.drawable.returnicon), contentDescription = null, modifier = Modifier.size(32.dp))
            Icon(painter = painterResource(R.drawable.swap), contentDescription = null, modifier = Modifier.size(32.dp))
        }

        Spacer(Modifier.height(16.dp))

        GameBoard()

        Spacer(Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { }) {
                Text("Play Again")
            }
            OutlinedButton(onClick = { }, enabled = false) {
                Text("Undo")
            }
        }

        Spacer(Modifier.height(8.dp))
        Text("You're out of undos!", color = Color.Gray)
    }
}