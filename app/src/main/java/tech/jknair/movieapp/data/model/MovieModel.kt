package tech.jknair.movieapp.data.model

data class MovieModel(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val rating: Float,
    val popularity: Double,
    val releaseDate: String,
)