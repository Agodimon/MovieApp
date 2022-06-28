package com.example.movieapp.screens.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.FavoriteFragmentBinding
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.screens.main.MainAdapter

class FavoriteFragment : Fragment(R.layout.favorite_fragment) {

    private lateinit var viewModel: FavoriteViewModel
    private var viewBinding: FavoriteFragmentBinding? = null
    private var recyclerView: RecyclerView? = null
    private val adapter by lazy { MainAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FavoriteFragmentBinding.bind(view)
        viewBinding = binding
        init()
    }

    private fun init() {
        recyclerView = viewBinding?.rvFavorite
        recyclerView?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }


}