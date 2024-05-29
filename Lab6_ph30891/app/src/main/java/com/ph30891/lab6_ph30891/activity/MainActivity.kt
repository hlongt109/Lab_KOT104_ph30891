package com.ph30891.lab6_ph30891.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ph30891.lab6_ph30891.model.Movie
import com.ph30891.lab6_ph30891.model.entities.ListType
import com.ph30891.lab6_ph30891.ui.theme.components.MovieColumnItem
import com.ph30891.lab6_ph30891.ui.theme.components.MovieItem
import com.ph30891.lab6_ph30891.ui.theme.screens.CinemaSeatBookingScreen
import com.ph30891.lab6_ph30891.ui.theme.screens.createTheaterSeating
import com.ph30891.lab6_ph30891.ui.theme.theme.Lab6_ph30891Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6_ph30891Theme {
//                MovieScreen(movies = Movie.getSampleMovies())
                CinemaSeatBookingScreen(
                    createTheaterSeating(
                        totalRows = 12,
                        totalSeatsPerRow = 9,
                        aislePositionInRow = 4,
                        aislePositionInColumn = 5
                    ), totalSeatsPerRow = 9
                )
            }
        }
    }
}

@Composable
fun MovieScreen(movies: List<Movie>) {
    var listType by remember { mutableStateOf(ListType.ROW) }

    Scaffold(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .statusBarsPadding(),
        topBar = {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(onClick = { listType = ListType.ROW }) {
                    Text("Row")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { listType = ListType.COLUMN }) {
                    Text("Column")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { listType = ListType.GRID }) {
                    Text("Grid")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            when (listType) {
                ListType.ROW -> MovieRow(movies)
                ListType.COLUMN -> MovieColumn(movies)
                ListType.GRID -> MovieGrid(movies)
            }
        }
    }
}

@Composable
fun MovieRow(movies: List<Movie>) {
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], listType = ListType.ROW)
        }
    }
}

@Composable
fun MovieColumn(movies: List<Movie>) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieColumnItem(movie = movies[index], listType = ListType.COLUMN)
        }
    }
}

@Composable
fun MovieGrid(movies: List<Movie>) {
    val gidState = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        state = gidState,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], listType = ListType.GRID)
        }
    }
}
