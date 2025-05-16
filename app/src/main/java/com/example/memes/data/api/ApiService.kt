package com.example.memes.data.api

import com.example.memes.domain.models.MemeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("get_memes")
    suspend fun getMemes():MemeResponse

}