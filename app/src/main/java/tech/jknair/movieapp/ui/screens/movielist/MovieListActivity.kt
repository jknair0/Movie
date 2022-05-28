package tech.jknair.movieapp.ui.screens.movielist

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import tech.jknair.movieapp.ui.base.ComposeActivity
import tech.jknair.movieapp.ui.screens.moviedetail.MovieDetailActivity
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Error
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Idle
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Loaded
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieScreenState.Loading
import tech.jknair.movieapp.ui.screens.movielist.MovieListViewModel.MovieUserAction
import tech.jknair.movieapp.ui.screens.movielist.components.FullScreenLoadingIndicator
import tech.jknair.movieapp.ui.screens.movielist.components.MovieList

@AndroidEntryPoint
class MovieListActivity : ComposeActivity() {

    @Composable
    override fun Content() {
        MovieListContainer()
    }

}

@Composable
fun MovieListContainer() {
    val viewModel = viewModel<MovieListViewModel>()
    LaunchedEffect(key1 = Unit, block = {
        viewModel.process(MovieUserAction.InitialScreenView)
    })

    val screenState = viewModel.screenStateFlow.collectAsState()

    when(val value = screenState.value) {
        Loading -> {
            FullScreenLoadingIndicator("Loading movies...")
        }
        is Error -> {

        }
        Idle -> {

        }
        is Loaded -> {
            val context = LocalContext.current
            MovieList(movieList = value.movies) { movieId ->
                context.startActivity(Intent(context, MovieDetailActivity::class.java).apply {
                    putExtra(MovieDetailActivity.MOVIE_ID, movieId)
                })
            }
        }
    }


}