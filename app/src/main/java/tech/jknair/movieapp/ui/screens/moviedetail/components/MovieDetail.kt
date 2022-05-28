package tech.jknair.movieapp.ui.screens.moviedetail.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImagePainter.State.Empty.painter
import tech.jknair.movieapp.data.model.MovieModel

@Composable
fun MovieDetail(movieModel: MovieModel) {
    TopAppBar {
        Icon(
            modifier = Modifier.clickable {

            },
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun MovieDetailPreview() {
    MovieDetail(
        MovieModel(
            title = "The Godfather: Part II",
            imageUrl = "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
            description = "Two imprisoned",
            id = 3,
            rating = 9.3f,
            releaseDate = "14-10-1994",
            popularity = 1.2
        )
    )
}
