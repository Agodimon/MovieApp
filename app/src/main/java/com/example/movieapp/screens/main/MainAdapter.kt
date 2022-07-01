package com.example.movieapp.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.BASE_IMAGE_URL
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemLayoutBinding
import com.example.movieapp.models.movieModel.MovieItemModel
import com.example.movieapp.util.OnClick

class MainAdapter(private val onClick: OnClick) :
    PagingDataAdapter<MovieItemModel, MainAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(
        val binding: ItemLayoutBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<MovieItemModel>() {
            override fun areItemsTheSame(
                oldItem: MovieItemModel,
                newItem: MovieItemModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieItemModel,
                newItem: MovieItemModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currMovie = getItem(position)
        holder.binding.apply {
            holder.itemView.apply {
                itemTitle.text = currMovie?.title
                verticalImdb.text = currMovie?.voteAverage.toString()
                itemDate.text = currMovie?.releaseDate
                setOnClickListener { onClick.onClick(checkNotNull(currMovie)) }

                Glide.with(holder.itemView.context)
                    .load("$BASE_IMAGE_URL${currMovie?.posterPath}")
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(itemImg)
            }
        }
    }


}