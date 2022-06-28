package com.example.movieapp.data.retrofit.api

import com.example.movieapp.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=95fb6cda812295a096fe775d6db46a71&language=en-US&page=1")
    suspend fun getPopularMovie():Response<MoviesModel>
}