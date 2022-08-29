package com.benten.rickandmorty.adapters.apis

import com.benten.rickandmorty.adapters.models.RickAndMortyCaractersResponse
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("/character")
    fun getAllCharacters():RickAndMortyCaractersResponse
}