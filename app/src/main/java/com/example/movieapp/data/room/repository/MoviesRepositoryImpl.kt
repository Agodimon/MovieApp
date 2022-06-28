package com.example.movieapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.movieapp.data.room.dao.MoviesDao
import com.example.movieapp.models.MovieItemModel

class MoviesRepositoryImpl(private val moviesDao: MoviesDao) : MoviesRepository {
    override val allMovies: LiveData<List<MovieItemModel>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovie(movieItemModel: MovieItemModel) {
        moviesDao.insert(movieItemModel)
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel) {
        moviesDao.delete(movieItemModel)
    }
}