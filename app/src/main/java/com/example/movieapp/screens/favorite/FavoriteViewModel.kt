package com.example.movieapp.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.REPOSITORY_IMPL
import com.example.movieapp.data.room.repository.MoviesRepositoryImpl
import com.example.movieapp.models.MovieItemModel

class FavoriteViewModel : ViewModel() {

    fun getAllMovies(): LiveData<List<MovieItemModel>> {
        return REPOSITORY_IMPL.allMovies
    }
}