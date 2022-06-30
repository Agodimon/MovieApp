package com.example.movieapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieapp.models.movieModel.MovieItemModel

@Dao
interface MoviesDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieItemModel: MovieItemModel)

    @Delete
    suspend fun delete(movieItemModel: MovieItemModel)

    @Query("SELECT*FROM movies_table")
    fun getAllMovies(): LiveData<List<MovieItemModel>>

}