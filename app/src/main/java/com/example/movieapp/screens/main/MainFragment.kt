package com.example.movieapp.screens.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: MainFragmentViewModel by viewModels()
    private var viewBinding: FragmentMainBinding? = null
    private var recyclerView: RecyclerView? = null
    private val adapter by lazy { MainAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)
        viewBinding = binding
        init()
        setHasOptionsMenu(true)
    }

    private fun init() {
        viewModel.getMovies()
        recyclerView = viewBinding?.rvMain
        recyclerView?.adapter = adapter
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.setList(list.body()!!.results)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}