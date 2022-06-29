package com.example.movieapp.data.retrofit

import com.example.movieapp.data.retrofit.api.RetrofitInstance
import com.example.movieapp.models.MoviesModel
import retrofit2.Response

class RetrofitRepository :RetrofitRepositoryInterface{
    override suspend fun getMovie():Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovie()
    }
}