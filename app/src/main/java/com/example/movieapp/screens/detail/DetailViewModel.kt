package com.example.movieapp.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.REPOSITORY_IMPL
import com.example.movieapp.data.room.repository.MoviesRepository
import com.example.movieapp.data.room.repository.MoviesRepositoryImpl
import com.example.movieapp.di.Di
import com.example.movieapp.models.MovieItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class DetailViewModel(val repository: MoviesRepository) : ViewModel() {

    fun insert(movieItemModel: MovieItemModel) = viewModelScope.launch(Dispatchers.IO) {

        repository.insertMovie(movieItemModel)
    }

    fun delete(movieItemModel: MovieItemModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteMovie(movieItemModel)
    }
}