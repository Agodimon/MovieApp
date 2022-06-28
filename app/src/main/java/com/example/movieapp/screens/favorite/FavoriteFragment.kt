package com.example.movieapp.screens.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.MAIN
import com.example.movieapp.R
import com.example.movieapp.databinding.FavoriteFragmentBinding
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.models.MovieItemModel
import com.example.movieapp.screens.main.MainAdapter

class FavoriteFragment : Fragment(R.layout.favorite_fragment) {

    private val viewModel: FavoriteViewModel by viewModels()
    private var viewBinding: FavoriteFragmentBinding? = null
    private var recyclerView: RecyclerView? = null
    private val adapter by lazy { FavoriteAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FavoriteFragmentBinding.bind(view)
        viewBinding = binding
        init()
    }

    private fun init() {
        recyclerView = viewBinding?.rvFavorite
        recyclerView?.adapter = adapter
        viewModel.getAllMovies().observe(viewLifecycleOwner) { list ->
            adapter.setList(list.asReversed())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    companion object {
        fun clickMovie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
        }
    }

}