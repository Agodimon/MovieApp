package com.example.movieapp.data.retrofit

import com.example.movieapp.models.MoviesModel
import retrofit2.Response

interface RetrofitRepositoryInterface {
    suspend fun getMovie(): Response<MoviesModel>
}