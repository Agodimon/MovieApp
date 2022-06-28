package com.example.movieapp.screens.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.databinding.FavoriteFragmentBinding
import com.example.movieapp.databinding.FragmentMainBinding

class FavoriteFragment : Fragment(R.layout.favorite_fragment) {

    private lateinit var viewModel: FavoriteViewModel
    private var viewBinding: FavoriteFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FavoriteFragmentBinding.bind(view)
        viewBinding = binding

    }
    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }


}