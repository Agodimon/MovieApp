package com.example.movieapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.movieapp.R
import com.example.movieapp.databinding.FavoriteFragmentBinding
import com.example.movieapp.databinding.FragmentDetailBinding
import com.example.movieapp.screens.favorite.FavoriteViewModel


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by viewModels()
    private var viewBinding: FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)
        viewBinding = binding

        init()
    }

    private fun init() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }


}