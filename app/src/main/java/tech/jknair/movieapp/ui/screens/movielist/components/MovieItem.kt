package tech.jknair.movieapp.ui.screens.movielist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import tech.jknair.movieapp.ui.theme.MovieAppTheme

@Composable
fun MovieItem(
    id: Int,
    title: String,
    description: String,
    imageUrl: String,
    onClick: (id: Int) -> Unit
) {
    Row(modifier = Modifier
        .padding(vertical = 16.dp)
        .height(100.dp)
        .fillMaxWidth()
        .clickable { onClick(id) }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "movie $title",
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxHeight()
                .clip(RoundedCornerShape(16.dp))
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, style = MaterialTheme.typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MovieAppTheme {
        MovieItem(
            id = 1,
            title = "Godzilla vs Kong",
            description = "A monster movie",
            imageUrl = "https://images-na.ssl-images-amazon.com/images/I/51Zr01SiCtL._AC_SY400_.jpg",
            onClick = { }
        )
    }
}