package py.com.alexsa.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import py.com.alexsa.movies.Screens.MainActivityScreen
import py.com.alexsa.movies.Screens.MovieDetailScreen

class MainActivity : ComponentActivity() {

    val listMovies = listOf(
        Movies("Movie 1", "Description 1", "https://picsum.photos/200/300?random=1"),
        Movies("Movie 2", "Description 2", "https://picsum.photos/200/300?random=2"),
        Movies("Movie 3", "Description 3", "https://picsum.photos/200/300?random=3"),
        Movies("Movie 4", "Description 4", "https://picsum.photos/200/300?random=4"),
        Movies("Movie 5", "Description 5", "https://picsum.photos/200/300?random=5"),
        Movies("Movie 6", "Description 6", "https://picsum.photos/200/300?random=6"),)

    val listTrendingMovies = listOf(
        Movies("Movie 4", "Description 4", "https://picsum.photos/200/300?random=7"),
        Movies("Movie 5", "Description 5", "https://picsum.photos/200/300?random=8"),
        Movies("Movie 6", "Description 6", "https://picsum.photos/200/300?random=9"),
        Movies("Movie 7", "Description 4", "https://picsum.photos/200/300?random=7"),
        Movies("Movie 8", "Description 5", "https://picsum.photos/200/300?random=8"),
        Movies("Movie 69", "Description 6", "https://picsum.photos/200/300?random=9"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MovieDetailScreen(listTrendingMovies)
        }
    }


}

