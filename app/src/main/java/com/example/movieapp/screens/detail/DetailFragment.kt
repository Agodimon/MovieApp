package com.example.movieapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.movieapp.BASE_IMAGE_URL
import com.example.movieapp.R
import com.example.movieapp.SaveSharedImpl
import com.example.movieapp.databinding.FragmentDetailBinding


import com.example.movieapp.models.MovieItemModel
import com.example.movieapp.screens.favorite.FavoriteViewModel


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by viewModels()
    private var viewBinding: FragmentDetailBinding? = null
    lateinit var currentMovieItemModel: MovieItemModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentMovieItemModel = arguments?.getSerializable("movie") as MovieItemModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)
        viewBinding = binding
        init()
    }

    private fun init() {
        var isFavorite = false
        val valueBoolean =
            SaveSharedImpl().getFavorite(requireContext(), currentMovieItemModel.id.toString())
        viewBinding?.let {
            Glide.with(this)
                .load("$BASE_IMAGE_URL${currentMovieItemModel.posterPath}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(it.imgDetail)

        }

        viewBinding?.tvTitle?.text = currentMovieItemModel.title
        viewBinding?.tvDate?.text = currentMovieItemModel.releaseDate
        viewBinding?.tvDescription?.text = currentMovieItemModel.overview

        if (isFavorite != valueBoolean) {
            viewBinding!!.imgIcFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            viewBinding!!.imgIcFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
        isFavorite = valueBoolean
        viewBinding?.imgIcFavorite?.setOnClickListener {

            isFavorite = if (!isFavorite) {
                viewBinding!!.imgIcFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                viewModel.insert(currentMovieItemModel)
                SaveSharedImpl().setFavorite(
                    requireContext(),
                    currentMovieItemModel.id.toString(),
                    true
                )
                true
            } else {
                viewBinding!!.imgIcFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                viewModel.delete(currentMovieItemModel)
                SaveSharedImpl().setFavorite(
                    requireContext(),
                    currentMovieItemModel.id.toString(),
                    false
                )
                false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }


}