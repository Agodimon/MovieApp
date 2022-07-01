package com.example.movieapp.application.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState

import com.example.movieapp.data.retrofit.RetrofitRepositoryInterface
import com.example.movieapp.models.movieModel.MovieItemModel
import com.example.movieapp.models.movieModel.MoviesModel

class MoviePagingSource
    (
    private val repoApiMovies: RetrofitRepositoryInterface
) : PagingSource<Int, MovieItemModel>() {

    override fun getRefreshKey(state: PagingState<Int, MovieItemModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, MovieItemModel> {

        return try {
            val currentPage = params.key ?: 1
            val response = repoApiMovies.getMovie(currentPage)
            val responseData = mutableListOf<MovieItemModel>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}