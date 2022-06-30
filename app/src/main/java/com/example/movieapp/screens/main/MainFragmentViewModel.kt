package com.example.movieapp.screens.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.retrofit.RetrofitRepositoryInterface
import com.example.movieapp.data.room.MoviesRoomDatabase
import com.example.movieapp.data.room.repository.MoviesRepository
import com.example.movieapp.data.room.repository.MoviesRepositoryImpl
import com.example.movieapp.models.movieModel.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(
    val context: Context,
    var repoRoomMovies: MoviesRepository,
    val repoApiMovies:RetrofitRepositoryInterface
) : ViewModel() {
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()


    fun getMovies() {
        viewModelScope.launch {
            myMovies.value = repoApiMovies.getMovie()
        }
    }

    fun initDataBase() {
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        repoRoomMovies = MoviesRepositoryImpl(daoMovie)
    }
}