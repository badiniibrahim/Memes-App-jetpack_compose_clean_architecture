package com.example.memes.presentation.MemesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.memes.presentation.MemesScreen.widgets.AppTopBar


@Composable
internal fun MemesScreen(
    viewModel: MemesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    MemesContent(viewState = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemesContent(
    viewState: MemesViewState
){
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            AppTopBar(title = "Memes Content")
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ){
            items(viewState.memesData){memes ->
                println(memes)
            }
        }
    }
}