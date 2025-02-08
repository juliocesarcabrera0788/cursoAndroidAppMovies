package py.com.alexsa.movies

import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import py.com.alexsa.movies.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val aa = innerPadding
                    content()
                }
            }
        }
    }
}
@Preview
@Composable
fun content() {
    MoviesTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(Black)
        ) {
            Column(Modifier.fillMaxWidth()) {
                Toolbar()
                TabBar()

                val listMovies = listOf(
                    Movies("Movie 1", "Description 1", "https://picsum.photos/200/300"),
                    Movies("Movie 2", "Description 2", "https://picsum.photos/200/300"),
                    Movies("Movie 3", "Description 3", "https://picsum.photos/200/300"),
                    Movies("Movie 4", "Description 4", "https://picsum.photos/200/300"),
                    Movies("Movie 5", "Description 5", "https://picsum.photos/200/300"),
                    Movies("Movie 6", "Description 6", "https://picsum.photos/200/300"),

                )

                ListMovies(listMovies)
            }
        }
    }
}

@Composable
fun ListMovies(listMovies: List<Movies> = listOf()) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listMovies.forEach { movie ->
            ItemMovis(movie)
        }
    }
}

@Composable
fun ItemMovis(movie:Movies) {
   Column() {
        Image(
            painter = rememberAsyncImagePainter(model= movie.imageUrl),
            contentDescription = "Movie Image"
        )
        Text(
            text = movie.title,
            color = White,
            fontSize = 16.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
   }
}

@Composable
fun TabBar() {
    val tabs = listOf("Popular", "In Theaters", "Coming Soon")
    var selectedTabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Black,
        contentColor = White,
        modifier = Modifier.fillMaxWidth()
    ){
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {selectedTabIndex = index},
                text = {
                    Text(
                        text = title,
                        color = if(selectedTabIndex==index) White else Gray,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            )
        }
    }
}

@Composable
fun Toolbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Black)
            .padding(horizontal = 10.dp, vertical = 20.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Icon(
            Icons.Filled.Menu,
            contentDescription = "Menu",
            tint = White
        )
        Text(
            text = "Movies",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = White,
            fontSize = 20.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}
