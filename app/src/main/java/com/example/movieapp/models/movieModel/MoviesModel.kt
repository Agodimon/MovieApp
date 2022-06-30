package com.example.movieapp.models.movieModel

data class MoviesModel(
    val page: Int,
    val results: List<MovieItemModel>,
    val total_pages: Int,
    val total_results: Int
)