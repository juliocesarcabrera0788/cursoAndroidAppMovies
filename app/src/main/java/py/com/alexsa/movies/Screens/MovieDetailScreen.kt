package py.com.alexsa.movies.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 *@author Julio Cabrera
 *Created 13/2/2025 at 21:00
 **/
@Preview
@Composable
fun MovieDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Black)
    ) {
        Text(
            text = "Movie Detail",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = White
        )
    }
}