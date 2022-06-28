package com.example.movieapp.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.BASE_IMAGE_URL
import com.example.movieapp.MAIN
import com.example.movieapp.R
import com.example.movieapp.models.MovieItemModel

class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    private var moviesList = emptyList<MovieItemModel>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_title).text = moviesList[position].title
        holder.itemView.findViewById<TextView>(R.id.item_date).text =
            moviesList[position].releaseDate
        Glide.with(holder.itemView.context)
            .load("$BASE_IMAGE_URL${moviesList[position].posterPath}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.findViewById(R.id.item_img))
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
    fun setList(list: List<MovieItemModel>){
        moviesList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.clickMovie(moviesList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}