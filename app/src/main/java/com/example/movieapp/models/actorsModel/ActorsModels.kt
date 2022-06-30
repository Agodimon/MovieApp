package com.example.movieapp.models.actorsModel


import com.google.gson.annotations.SerializedName

data class ActorsModels(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
)