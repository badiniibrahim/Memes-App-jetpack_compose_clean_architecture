package com.example.memes.presentation.MemesScreen

import com.example.memes.domain.models.Meme

data class MemesViewState(
    val isLoading:Boolean = false,
    val memesData: List<Meme> = emptyList(),
    val errorMessage:String?= null
)
