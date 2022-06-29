package com.example.movieapp.screens.detail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.retrofit.RetrofitRepositoryInterface
import com.example.movieapp.data.room.repository.MoviesRepository
import com.example.movieapp.models.actorsModel.ActorsModels
import com.example.movieapp.models.movieModel.MovieItemModel
import com.example.movieapp.models.movieModel.MoviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class DetailViewModel(
    val context: Context,
    var repoRoomMovies: MoviesRepository,
    val repoApiMovies: RetrofitRepositoryInterface
) : ViewModel() {
    val actors: MutableLiveData<Response<ActorsModels>> = MutableLiveData()
    fun insert(movieItemModel: MovieItemModel) = viewModelScope.launch(Dispatchers.IO) {

        repoRoomMovies.insertMovie(movieItemModel)
    }

    fun delete(movieItemModel: MovieItemModel) = viewModelScope.launch(Dispatchers.IO) {
        repoRoomMovies.deleteMovie(movieItemModel)
    }

    fun getActors(id: Int) {
        viewModelScope.launch {
            actors.value = repoApiMovies.getActorsMovie(id = id)
        }
    }
}