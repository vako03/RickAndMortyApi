package com.benten.rickandmorty.adapters.models


import com.google.gson.annotations.SerializedName

data class RickAndMortyCaractersResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)