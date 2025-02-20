package py.com.alexsa.movies.Screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import py.com.alexsa.movies.Movies
import java.time.format.TextStyle

/**
 *@author Julio Cabrera
 *Created 13/2/2025 at 21:00
 **/
@Preview
@Composable
fun MovieDetailScreen(listMoreMovies: List<Movies>) {
    val movie = Movies(
        title = "La Mascara",
        description = "Una pelicula de mierda, Una pelicula de mierda, Una pelicula de mierda, Una pelicula de mierda",
        imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEglsuV8wrLxF88zWhabGp7cFIMJbs60KETlhZdZIcjKM_R4ug9-D6dGycMn2uAYePyJy9dA1baT5QA5G9mOplD91bDp_8P-TOaA2Ue_9URMoWFLpm_x3z15F5c1eUoWE3-D9ViY/s704/Pel%25C3%25ADculas+de+culto+-+La+m%25C3%25A1scara+01.jpg",
        year = 2023,
        duration = "1 HR 20 MIN",
        nose = "R",
        quality = "HD"
    )


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarJc(movie) },
        bottomBar = { BottomBar() }
    ) { innerPadding ->


        Content(
            padding = innerPadding,
            movie = movie,
            listMovies = listMoreMovies
        )
    }
}

@Composable
fun TopBarJc(movie: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Black)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "",
            modifier = Modifier.size(24.dp),
            tint = White
        )

        Text(movie.title, fontWeight = Bold, fontSize = 16.sp, color = White)

        Spacer(modifier = Modifier.width(16.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Black,
            titleContentColor = White
        ),
        modifier = Modifier.background(Black),
        title = { Text(title) },
        navigationIcon = {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Atrás",
                tint = White,
            )
        }
    )
}

@Composable
fun Content(padding: PaddingValues, movie: Movies, listMovies: List<Movies>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Black)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberAsyncImagePainter(model = movie.imageUrl),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .size(430.dp)
            )
            Text(
                movie.title,
                fontWeight = Bold,
                fontSize = 24.sp,
                color = White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 20.dp, bottom = 20.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "${movie.duration} | ${movie.nose} | ${movie.year} | ${movie.quality}",
                color = White,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
            )
            Buttons()
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        movie.description,
                        color = White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(15.dp)
                    )
                }
                item {
                    MoreLikeThis(listMovies)
                }
                item {
                    Spacer(modifier = Modifier.padding(10.dp))
                }
                item {
                    Text(
                        text = "Cast & Crew",
                        color = White,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(15.dp)
                    )
                }
                item {
                    Text(
                        movie.description,
                        color = White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(15.dp)
                    )
                }
            }


        }
    }
}

@Composable
fun Buttons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Row{
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Agregar",
                tint = White,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Icon(
                imageVector = Icons.Filled.Download,
                contentDescription = "Descargar",
                tint = White,
                modifier = Modifier.size(35.dp)
            )
        }

        Icon(
            imageVector = Icons.Filled.PlayCircle,
            contentDescription = "Descargar",
            tint = White,
            modifier = Modifier.size(35.dp)
        )

    }
}

@Composable
fun MoreLikeThis(listMovies: List<Movies> = listOf()) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "More Like This",
            color = White,
            fontSize = 18.sp,
            style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Bold)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listMovies) { movie ->
                ItemMovis(movie)
            }
        }
    }
}