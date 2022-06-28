package com.example.movieapp.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity(tableName = "movies_table")
data class MovieItemModel(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,

    @ColumnInfo
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,

    @ColumnInfo
    @SerializedName("poster_path")
    val posterPath: String,

    @ColumnInfo
    @SerializedName("release_date")
    val releaseDate: String,

    @ColumnInfo
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Serializable