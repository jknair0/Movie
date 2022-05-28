package tech.jknair.movieapp.ui.screens.moviedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import tech.jknair.movieapp.ui.base.ComposeActivity
import tech.jknair.movieapp.ui.screens.moviedetail.MovieDetailViewModel.MovieDetailScreenState
import tech.jknair.movieapp.ui.screens.moviedetail.MovieDetailViewModel.MovieDetailUserAction
import tech.jknair.movieapp.ui.screens.moviedetail.components.MovieDetail
import tech.jknair.movieapp.ui.screens.movielist.MovieListContainer
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Error
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Idle
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Loaded
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Loading
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieUserAction
import tech.jknair.movieapp.ui.screens.movielist.components.FullScreenLoadingIndicator
import tech.jknair.movieapp.ui.screens.movielist.components.MovieList

@AndroidEntryPoint
class MovieDetailActivity : ComposeActivity() {

    @Composable
    override fun Content() {
        val movieId = remember { intent.getIntExtra(MOVIE_ID, 0) }
        MovieDetailContainer(movieId = movieId)
    }

    companion object {

        const val MOVIE_ID = "MOVIE_ID"

    }

}

@Composable
fun MovieDetailContainer(movieId: Int) {
    val viewModel = viewModel<MovieDetailViewModel>()
    LaunchedEffect(key1 = Unit, block = {
        viewModel.process(MovieDetailUserAction.Load(movieId))
    })

    val screenState = viewModel.screenStateFlow.collectAsState()

    when (val value = screenState.value) {
        MovieDetailScreenState.Loading -> {
            FullScreenLoadingIndicator(message = "Loading Details...")
        }
        is MovieDetailScreenState.Loaded -> {
            MovieDetail(movieModel = value.movie)
        }
        MovieDetailScreenState.Idle -> {

        }
        is MovieDetailScreenState.Error -> {

        }
    }

}