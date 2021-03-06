package com.example.movieapp.data.retrofit

import com.example.movieapp.data.retrofit.api.RetrofitInstance
import com.example.movieapp.models.actorsModel.ActorsModels
import com.example.movieapp.models.movieModel.MoviesModel
import retrofit2.Response

class RetrofitRepository : RetrofitRepositoryInterface {
    override suspend fun getMovie(page:Int): Response<MoviesModel> {
        return RetrofitInstance.api.getPopularMovie(page)
    }

    override suspend fun getActorsMovie(id: Int): Response<ActorsModels> {
        return RetrofitInstance.api.getActorsMovie(id)
    }

}