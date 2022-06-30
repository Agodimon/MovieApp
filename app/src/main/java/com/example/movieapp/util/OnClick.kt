package com.example.movieapp.util

import com.example.movieapp.models.movieModel.MovieItemModel

interface OnClick {
    fun onClick(model: MovieItemModel)
}