package com.example.movieapp.screens.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.BASE_IMAGE_URL
import com.example.movieapp.R
import com.example.movieapp.models.actorsModel.Cast

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {
    private var actorList = emptyList<Cast>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_movie_actors, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.itemView.findViewById<TextView>(R.id.item_name_actor).text =
            actorList[position].name

        Glide.with(holder.itemView.context)
            .load("$BASE_IMAGE_URL${actorList[position].profilePath}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.findViewById(R.id.item_img_movie_actor))
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    fun setList(list: List<Cast>) {
        actorList = list
        notifyItemChanged(itemCount)
    }
}