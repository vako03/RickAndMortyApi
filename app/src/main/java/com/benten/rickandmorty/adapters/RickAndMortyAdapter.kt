package com.benten.rickandmorty.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benten.rickandmorty.adapters.models.Character
import com.benten.rickandmorty.databinding.LayoutCharacterItemBinding
import com.bumptech.glide.Glide


class RickAndMortyAdapter() : RecyclerView.Adapter<RickAndMortyAdapter.RickAndMortyViewHolder>() {

    private val itemsList = mutableListOf<Character>()


    fun updateAll(list: List<Character>){
        itemsList.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        val binding =
            LayoutCharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickAndMortyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        val character = itemsList[position]
        Glide.with(holder.itemView.context).load(character.image).into(holder.binding.ivAvatar)
        holder.binding.tvName.text = character.name
        holder.binding.tvLastLocation.text=character.location.name

    }



    override fun getItemCount(): Int {
        return itemsList.size
    }


    inner class RickAndMortyViewHolder( val binding: LayoutCharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}