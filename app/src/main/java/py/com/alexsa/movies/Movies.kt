package py.com.alexsa.movies

import android.icu.number.IntegerWidth

/**
 *@author Julio Cabrera
 *Created 7/2/2025 at 21:46
 **/
data class Movies(
    val title: String,
    val description: String,
    val imageUrl: String,
    var year: Int = 0,
    var duration: String = "1 HR 20 MIN",
    var quality: String = "HD",
    var nose : String = "R"
)
