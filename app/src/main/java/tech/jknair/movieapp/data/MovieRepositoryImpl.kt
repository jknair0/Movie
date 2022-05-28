package tech.jknair.movieapp.data

import tech.jknair.movieapp.data.model.MovieModel
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(): MovieRepository {
    override suspend fun getAllMovies(): List<MovieModel> {
        return listOf(
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
            )
        )
    }

    override fun getMovieModel(id: Int): MovieModel {
        return MovieModel(
            title = "The Godfather: Part II",
            imageUrl = "https://m.media-amazon.com/images/M/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
            description = "Two imprisoned",
            id = 3,
            rating = 9.3f,
            releaseDate = "14-10-1994",
            popularity = 1.2
        )
    }

}