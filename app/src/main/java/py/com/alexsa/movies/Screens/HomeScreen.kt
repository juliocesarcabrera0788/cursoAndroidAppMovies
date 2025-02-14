package py.com.alexsa.movies.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import py.com.alexsa.movies.Movies
import py.com.alexsa.movies.R
import py.com.alexsa.movies.ui.theme.MoviesTheme

/**
 *@author Julio Cabrera
 *Created 13/2/2025 at 20:55
 **/
@Composable
fun MainActivityScreen(listMovies: List<Movies>, listTrendingMovies: List<Movies>) {
    MoviesTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = { Toolbar() },
            bottomBar = { BottomBar() })
        { innerPadding ->
            Content(
                padding = innerPadding,
                listMovies = listMovies,
                listTrendingMovies = listTrendingMovies
            )
        }
    }
}


@Composable
fun Content(padding: PaddingValues, listMovies: List<Movies>, listTrendingMovies: List<Movies>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Black)
    ) {
        TabBar()
        Spacer(modifier = Modifier.padding(10.dp))
        ListMovies(listMovies)
        Spacer(modifier = Modifier.padding(10.dp))
        TrendingMovies(listTrendingMovies)
    }
}

@Composable
fun ListMovies(listMovies: List<Movies> = listOf()) {
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

@Composable
fun ItemMovis(movie: Movies) {

    Column() {
        Image(
            painter = rememberAsyncImagePainter(model = movie.imageUrl),
            contentDescription = "Movie Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 150.dp, height = 200.dp)
                .clip(RoundedCornerShape(10.dp))

        )
        Spacer(modifier = Modifier.padding(8.dp))

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
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                text = {
                    Text(
                        text = title,
                        color = if (selectedTabIndex == index) White else Gray,
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

@Composable
fun TrendingMovies(listMovies: List<Movies> = listOf()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Trending",
            color = White,
            fontSize = 20.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listMovies) { movie ->
                MovieGridItem(movie = movie)
            }
        }
    }
}

@Composable
fun MovieGridItem(movie: Movies) {
    Column() {
        Image(
            painter = rememberAsyncImagePainter(model = movie.imageUrl),
            contentDescription = "Movie Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
                .aspectRatio(16f / 9)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(text = movie.title)
        Text(
            text = movie.description,
            color = Gray,
            fontSize = 12.sp,
            style = TextStyle(fontWeight = FontWeight.Light)
        )
    }
}

@Composable
fun BottomBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Movie", "TV", "Download", "Search")
    val icons = listOf(
        Icons.Filled.Home,
        ImageVector.vectorResource(id = R.drawable.camara),
        ImageVector.vectorResource(id = R.drawable.tv),
        Icons.Filled.Download,
        Icons.Filled.Search
    )

    NavigationBar(
        containerColor = Black.copy(alpha = 0.95f),
        contentColor = White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        icons[index],
                        contentDescription = item,
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = White,
                    unselectedIconColor = Gray,
                    selectedTextColor = White,
                    unselectedTextColor = Gray,
                    indicatorColor = Color.Transparent // Evita que se dibuje el círculo
                )
            )
        }
    }
}