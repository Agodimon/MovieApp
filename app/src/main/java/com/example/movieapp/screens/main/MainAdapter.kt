package com.example.movieapp.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.models.MovieItemModel

class MainAdapter:RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    private val moviesList = emptyList<MovieItemModel>()

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_title).text = moviesList[position].title
        holder.itemView.findViewById<TextView>(R.id.item_date).text = moviesList[position].releaseDate
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}