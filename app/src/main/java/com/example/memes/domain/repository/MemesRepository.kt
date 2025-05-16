package com.example.memes.domain.repository

import arrow.core.Either
import com.example.memes.domain.models.MemeResponse
import com.example.memes.domain.models.NetworkError

interface MemesRepository {
    suspend fun getAllMemes():Either<NetworkError, MemeResponse>
}