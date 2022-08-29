package com.benten.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.benten.rickandmorty.adapters.RickAndMortyAdapter
import com.benten.rickandmorty.adapters.apis.RickAndMortyApi
import com.benten.rickandmorty.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    private  val rickAndMortyAdapter = RickAndMortyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rickAndMortyApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java )
        binding.rvRickMorty.adapter = rickAndMortyAdapter
        binding.rvRickMorty.layoutManager = LinearLayoutManager(this,LinearLayoutManager.
        VERTICAL, false)

        val response = rickAndMortyApi.getAllCharacters()

        rickAndMortyAdapter.updateAll(response.characters)

    }
    companion object{
        const val BASE_URL = "https://rickandmortyapi.com/api"
    }
}