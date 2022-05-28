package tech.jknair.movieapp.data

import tech.jknair.movieapp.data.model.MovieModel

interface MovieRepository {

    suspend fun getAllMovies(): List<MovieModel>

    fun getMovieModel(id: Int): MovieModel

}