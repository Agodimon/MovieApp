package com.example.movieapp.di.modules

import android.content.Context
import com.example.movieapp.data.room.MoviesRoomDatabase
import com.example.movieapp.data.room.dao.MoviesDao


class RoomModule(val context: Context) : RoomModuleInt {
    override fun getMovieDao():MoviesDao {
       return MoviesRoomDatabase.getInstance(context).getMovieDao()
    }

}

