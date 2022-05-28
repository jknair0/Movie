package tech.jknair.movieapp.ui.screens.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import tech.jknair.movieapp.data.MovieRepository
import tech.jknair.movieapp.data.model.MovieModel
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenEvent
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _screenStateFlow = MutableStateFlow<MovieDetailScreenState>(MovieDetailScreenState.Idle)
    val screenStateFlow = _screenStateFlow.asStateFlow()

    private val eventChannel = Channel<MovieScreenEvent>()
    val eventFlow = eventChannel.consumeAsFlow()

    fun process(userAction: MovieDetailUserAction) {
        when (userAction) {
            is MovieDetailUserAction.Load -> loadMovie(userAction.movieId)
        }
    }

    private fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            try {
                _screenStateFlow.value = MovieDetailScreenState.Loading
                val movieModel = movieRepository.getMovieModel(movieId)
                _screenStateFlow.value = MovieDetailScreenState.Loaded(movieModel)
            }catch (e: Exception) {
                _screenStateFlow.value = MovieDetailScreenState.Error(e)
            }
        }
    }

    sealed interface MovieDetailUserAction {

        data class Load(val movieId: Int) : MovieDetailUserAction

    }

    sealed interface MovieDetailScreenState {

        object Idle : MovieDetailScreenState

        object Loading : MovieDetailScreenState

        data class Loaded(val movie: MovieModel) : MovieDetailScreenState

        data class Error(val error: Throwable) : MovieDetailScreenState

    }

}