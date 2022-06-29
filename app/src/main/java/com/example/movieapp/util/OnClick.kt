package com.example.movieapp.util

import com.example.movieapp.models.MovieItemModel

interface OnClick {
    fun onClick(model: MovieItemModel)
}