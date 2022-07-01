package com.example.movieapp.data.retrofit.api

import com.example.movieapp.models.actorsModel.ActorsModels
import com.example.movieapp.models.movieModel.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/popular?api_key=95fb6cda812295a096fe775d6db46a71&language=en-US")
    suspend fun getPopularMovie(@Query("page") int: Int): Response<MoviesModel>

    @GET("3/movie/{id}/credits?api_key=95fb6cda812295a096fe775d6db46a71&language=en-US")
    suspend fun getActorsMovie(@Path("id") int: Int): Response<ActorsModels>

}