package com.example.movieapp.screens.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.MAIN
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.models.MovieItemModel
import com.example.movieapp.util.OnClick
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: MainFragmentViewModel by viewModel()
    private var viewBinding: FragmentMainBinding? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initDataBase()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)
        viewBinding = binding
        init()
        setHasOptionsMenu(true)
    }

    private fun init() {
        adapter = MainAdapter(object : OnClick {
            override fun onClick(model: MovieItemModel) {
                val bundle = Bundle()
                bundle.putSerializable("movie", model)
                MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
            }

        })
        viewModel.getMovies()
        recyclerView = viewBinding?.rvMain
        recyclerView?.adapter = adapter
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter?.setList(list.body()!!.results)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_favorite -> {
                findNavController().navigate(R.id.action_mainFragment_to_favoriteFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}