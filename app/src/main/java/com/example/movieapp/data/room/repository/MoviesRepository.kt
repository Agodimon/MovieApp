package com.example.movieapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.movieapp.models.movieModel.MovieItemModel

interface MoviesRepository {
    val allMovies: LiveData<List<MovieItemModel>>
    suspend fun insertMovie(movieItemModel: MovieItemModel)
    suspend fun deleteMovie(movieItemModel: MovieItemModel)
}