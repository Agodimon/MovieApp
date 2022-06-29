package com.example.movieapp.util

interface SaveSharedInterface {
    fun setFavorite( key: String, value: Boolean)
    fun getFavorite( key: String): Boolean
}