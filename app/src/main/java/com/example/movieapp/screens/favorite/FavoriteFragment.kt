package com.example.movieapp.screens.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.FavoriteFragmentBinding
import com.example.movieapp.models.MovieItemModel
import com.example.movieapp.screens.main.MainAdapter
import com.example.movieapp.util.OnClick
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment(R.layout.favorite_fragment) {

    private val viewModel: FavoriteViewModel by viewModel()
    private var viewBinding: FavoriteFragmentBinding? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: MainAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FavoriteFragmentBinding.bind(view)
        viewBinding = binding
        init()
    }

    private fun init() {
        adapter = MainAdapter(object : OnClick {
            override fun onClick(model: MovieItemModel) {
                val bundle = Bundle()
                bundle.putSerializable("movie", model)
                findNavController().navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
            }

        })
        recyclerView = viewBinding?.rvFavorite
        recyclerView?.adapter = adapter
        viewModel.getAllMovies().observe(viewLifecycleOwner) { list ->
            adapter?.setList(list.asReversed())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}