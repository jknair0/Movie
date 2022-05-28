package tech.jknair.movieapp.ui.screens.moviedetail.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import tech.jknair.movieapp.data.model.MovieModel
import tech.jknair.movieapp.ui.screens.moviedetail.MovieDetailActivity

@Composable
fun MovieDetail(movieModel: MovieModel) {

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
