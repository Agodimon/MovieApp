package com.example.movieapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.data.room.dao.MoviesDao
import com.example.movieapp.models.MoviesModel

@Database(entities = [MoviesModel::class], version = 1)
abstract class MoviesRoomDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MoviesDao

    companion object {
        private var database: MoviesRoomDatabase? = null
        fun getInstance(context: Context):RoomDatabase{
            return if (database==null){
                database = Room
                    .databaseBuilder(context,MoviesRoomDatabase::class.java,"db_movies")
                    .build()
                database as MoviesRoomDatabase
            }else{
                database as MoviesRoomDatabase
            }
        }
    }
}