package com.example.movieapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FavoriteFragmentBinding
import com.example.movieapp.databinding.FragmentDetailBinding
import com.example.movieapp.models.MovieItemModel
import com.example.movieapp.screens.favorite.FavoriteViewModel


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by viewModels()
    private var viewBinding: FragmentDetailBinding? = null
    lateinit var currentMovieItemModel: MovieItemModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentMovieItemModel = arguments?.getSerializable("movie") as MovieItemModel
        val binding = FragmentDetailBinding.bind(view)
        viewBinding = binding
        init()
    }

    private fun init() {
        viewBinding?.let {
            Glide.with(this)
                .load(currentMovieItemModel.posterPath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(it.imgDetail)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }


}