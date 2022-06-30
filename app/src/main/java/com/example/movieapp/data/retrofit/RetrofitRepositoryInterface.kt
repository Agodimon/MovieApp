package com.example.movieapp.data.retrofit

import com.example.movieapp.models.actorsModel.ActorsModels
import com.example.movieapp.models.movieModel.MoviesModel
import retrofit2.Response

interface RetrofitRepositoryInterface {
    suspend fun getMovie(): Response<MoviesModel>
    suspend fun getActorsMovie(id: Int): Response<ActorsModels>
}