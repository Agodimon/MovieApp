package com.example.movieapp.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.screens.favorite.FavoriteViewModel


class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var viewModel: MainFragmentViewModel
    private var viewBinding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)
        viewBinding = binding

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}