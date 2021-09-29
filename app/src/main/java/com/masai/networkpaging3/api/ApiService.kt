package com.masai.networkpaging3.api

import com.masai.networkpaging3.model.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        val BASE_URL = "https://rickandmortyapi.com/"
    }

    @GET("api/character")
    suspend fun getCharactersByPage(@Query("page") page: Int): ResponseDTO
}