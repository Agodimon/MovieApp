package com.example.movieapp.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.room.repository.MoviesRepository
import com.example.movieapp.models.movieModel.MovieItemModel

class FavoriteViewModel(val repository: MoviesRepository) : ViewModel() {

    fun getAllMovies(): LiveData<List<MovieItemModel>> {
        return repository.allMovies
    }
}