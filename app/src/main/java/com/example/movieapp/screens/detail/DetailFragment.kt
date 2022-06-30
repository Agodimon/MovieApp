package com.example.movieapp.screens.detail


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.BASE_IMAGE_URL
import com.example.movieapp.R
import com.example.movieapp.SAVE_SHARED
import com.example.movieapp.databinding.FragmentDetailBinding

import com.example.movieapp.models.movieModel.MovieItemModel
import com.example.movieapp.screens.main.MainAdapter
import com.example.movieapp.util.SaveSharedInterface
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by viewModel()
    private var viewBinding: FragmentDetailBinding? = null
    private var recyclerView: RecyclerView? = null
    lateinit var currentMovieItemModel: MovieItemModel

    private val saveShared: SaveSharedInterface by inject(named(SAVE_SHARED))
    private var adapter: DetailAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)
        viewBinding = binding
        init()
    }

    private fun init() {
        currentMovieItemModel = arguments?.getSerializable("movie") as MovieItemModel
        val idMovie = arguments?.get("id_movie") as Int
        adapter = DetailAdapter()
        var isFavorite = false
        val valueBoolean =
            saveShared.getFavorite(currentMovieItemModel.id.toString())
        viewModel.getActors(idMovie)
        recyclerView = viewBinding?.rvMovieActors
        recyclerView?.adapter = adapter
        viewModel.actors.observe(viewLifecycleOwner) { list ->
            adapter?.setList(list.body()!!.cast)

        }
        viewBinding?.let {
            Glide.with(this)
                .load("$BASE_IMAGE_URL${currentMovieItemModel.posterPath}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(it.imgDetail)

        }

        viewBinding?.tvTitle?.text = currentMovieItemModel.title
        viewBinding?.verticalImdb?.text = currentMovieItemModel.voteAverage.toString()
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
                saveShared.setFavorite(
                    currentMovieItemModel.id.toString(),
                    true
                )
                true
            } else {
                viewBinding!!.imgIcFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                viewModel.delete(currentMovieItemModel)
                saveShared.setFavorite(
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