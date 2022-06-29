package com.example.movieapp.screens.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.REPOSITORY_IMPL
import com.example.movieapp.data.retrofit.RetrofitRepository
import com.example.movieapp.data.retrofit.RetrofitRepositoryInterface
import com.example.movieapp.data.room.MoviesRoomDatabase
import com.example.movieapp.data.room.dao.MoviesDao
import com.example.movieapp.data.room.repository.MoviesRepository
import com.example.movieapp.data.room.repository.MoviesRepositoryImpl
import com.example.movieapp.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(
    val context: Context,
    val repoRoomMovies: MoviesRepository,
    val repoApiMovies:RetrofitRepositoryInterface
) : ViewModel() {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()


    fun getMovies() {
        viewModelScope.launch {
            myMovies.value = repoApiMovies.getMovie()
        }
    }

    fun initDataBase() {
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REPOSITORY_IMPL = MoviesRepositoryImpl(daoMovie)
    }
}