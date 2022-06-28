package com.example.movieapp.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.REPOSITORY_IMPL
import com.example.movieapp.data.room.repository.MoviesRepositoryImpl
import com.example.movieapp.models.MovieItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:ViewModel() {

    fun insert(movieItemModel: MovieItemModel) = viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY_IMPL.insertMovie(movieItemModel)
    }
    fun delete(movieItemModel: MovieItemModel) = viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY_IMPL.deleteMovie(movieItemModel)
    }
}