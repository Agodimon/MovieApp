package com.example.movieapp.di.modules

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.movieapp.data.room.MoviesRoomDatabase
import com.example.movieapp.data.room.dao.MoviesDao
import com.example.movieapp.models.MovieItemModel
import org.koin.android.ext.koin.androidContext


class RoomModule(val context: Context) : RoomModuleInt {
    override fun getMovieDao():MoviesDao {
       return MoviesRoomDatabase.getInstance(context).getMovieDao()
    }

}

