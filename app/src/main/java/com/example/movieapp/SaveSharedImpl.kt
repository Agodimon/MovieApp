package com.example.movieapp

import android.content.Context
import android.preference.PreferenceManager


class SaveSharedImpl {

        fun setFavorite(context: Context?, key: String, value: Boolean){
            val setFavoriteShared = context?.let {
                PreferenceManager.getDefaultSharedPreferences(it) }
            setFavoriteShared
                ?.edit()
                ?.putBoolean(key, value)
                ?.apply()
        }
        fun getFavorite(context: Context?, key: String): Boolean{
            val getFavoriteShared = context?.let {
                PreferenceManager.getDefaultSharedPreferences(it) }
            return getFavoriteShared
                ?.getBoolean(key, false)
                ?: true
        }
}
