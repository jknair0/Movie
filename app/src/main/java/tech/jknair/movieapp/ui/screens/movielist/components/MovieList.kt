package tech.jknair.movieapp.ui.screens.movielist.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.jknair.movieapp.data.model.MovieModel

@Composable
fun MovieList(movieList: List<MovieModel>, onClick: (id: Int) -> Unit) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(movieList.size, { index -> movieList[index].id }) { i ->
            val movieModel = movieList[i]
            MovieItem(
                id = movieModel.id,
                title = movieModel.title,
                imageUrl = movieModel.imageUrl,
                description = movieModel.description,
                onClick = onClick
            )
        }
    }
}

@Preview
@Composable
fun MovieListPreview() {
    MovieList(
        listOf(
            MovieModel(
                title = "The Shawshank Redemption",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                description = "Two imprisoned",
                id = 1,
                rating = 9.3f,
                releaseDate = "14-10-1994",
                popularity = 1.2
            ),
            MovieModel(
                title = "The Godfather",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                description = "Two imprisoned",
                id = 2,
                rating = 9.3f,
                releaseDate = "14-10-1994",
                popularity = 1.2
            ),
            MovieModel(
                title = "The Godfather: Part II",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                description = "Two imprisoned",
                id = 3,
                rating = 9.3f,
                releaseDate = "14-10-1994",
                popularity = 1.2
            ),
        ),
        onClick = {

        }
    )
}