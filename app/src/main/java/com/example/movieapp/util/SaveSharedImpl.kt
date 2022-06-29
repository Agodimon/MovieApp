package com.example.movieapp.util

import android.content.Context
import androidx.preference.PreferenceManager


class SaveSharedImpl(var context: Context) : SaveSharedInterface {

    override fun setFavorite(key: String, value: Boolean) {
        val setFavoriteShared =
            PreferenceManager.getDefaultSharedPreferences(context)
        setFavoriteShared
            ?.edit()
            ?.putBoolean(key, value)
            ?.apply()
    }

    override fun getFavorite(key: String): Boolean {
        val getFavoriteShared =
            PreferenceManager.getDefaultSharedPreferences(context)
        return getFavoriteShared
            ?.getBoolean(key, false)
            ?: true
    }
}
