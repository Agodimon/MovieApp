package com.example.movieapp.di.modules

import com.example.movieapp.data.room.dao.MoviesDao


interface RoomModuleInt {
    fun getMovieDao(): MoviesDao
}