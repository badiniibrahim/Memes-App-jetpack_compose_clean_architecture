package com.example.memes.data.repository

import arrow.core.Either
import com.example.memes.data.api.ApiService
import com.example.memes.data.mapper.toGeneralError
import com.example.memes.domain.models.MemeResponse
import com.example.memes.domain.models.NetworkError
import com.example.memes.domain.repository.MemesRepository
import javax.inject.Inject

class MemesRepositoryImpl @Inject constructor(
    private val api:ApiService
): MemesRepository {

    override suspend fun getAllMemes(): Either<NetworkError, MemeResponse> {
        return Either.catch {
            api.getMemes()
        }.mapLeft { it.toGeneralError() }
    }
}