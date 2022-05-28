package tech.jknair.movieapp.ui.screens.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import tech.jknair.movieapp.data.MovieRepository
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieUserAction.InitialScreenView
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieUserAction.SelectMovie
import tech.jknair.movieapp.data.model.MovieModel
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieUserAction.RetryLoadMovies
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _screenStateFlow = MutableStateFlow<MovieScreenState>(MovieScreenState.Idle)
    val screenStateFlow = _screenStateFlow.asStateFlow()

    private val eventChannel = Channel<MovieScreenEvent>()
    val eventFlow = eventChannel.consumeAsFlow()

    fun process(userAction: MovieUserAction) {
        when (userAction) {
            InitialScreenView -> {
                if (screenStateFlow.value == MovieScreenState.Idle) {
                    fetchMovies()
                }
            }
            RetryLoadMovies -> {
                fetchMovies()
            }
            is SelectMovie -> {
                eventChannel.trySend(MovieScreenEvent.MovieSelected(userAction.movieModel))
            }
        }
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            try {
                _screenStateFlow.value = MovieScreenState.Loading
                val movies = movieRepository.getAllMovies()
                _screenStateFlow.value = MovieScreenState.Loaded(movies)
            } catch (e: Exception) {
                _screenStateFlow.value = MovieScreenState.Error(e)
            }
        }
    }

    sealed interface MovieUserAction {
        object InitialScreenView : MovieUserAction
        object RetryLoadMovies: MovieUserAction
        data class SelectMovie(val movieModel: MovieModel) : MovieUserAction
    }

    sealed interface MovieScreenEvent {
        data class MovieSelected(val movieModel: MovieModel) : MovieScreenEvent
    }

    sealed interface MovieScreenState {

        object Idle : MovieScreenState

        object Loading : MovieScreenState

        data class Error(val throwable: Throwable) : MovieScreenState

        data class Loaded(val movies: List<MovieModel>) : MovieScreenState
    }

}