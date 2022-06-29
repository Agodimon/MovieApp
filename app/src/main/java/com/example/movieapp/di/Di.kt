package com.example.movieapp.di

import com.example.movieapp.MOVIES_REPO_API
import com.example.movieapp.MOVIES_REPO_ROOM
import com.example.movieapp.SAVE_SHARED
import com.example.movieapp.data.retrofit.RetrofitRepository
import com.example.movieapp.data.retrofit.RetrofitRepositoryInterface
import com.example.movieapp.data.room.repository.MoviesRepository
import com.example.movieapp.data.room.repository.MoviesRepositoryImpl
import com.example.movieapp.di.modules.RoomModule
import com.example.movieapp.screens.detail.DetailViewModel
import com.example.movieapp.screens.favorite.FavoriteViewModel
import com.example.movieapp.screens.main.MainFragmentViewModel
import com.example.movieapp.util.SaveSharedImpl
import com.example.movieapp.util.SaveSharedInterface
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Di {

    val mainModule = module {

        single<SaveSharedInterface>(named(SAVE_SHARED)) { SaveSharedImpl(androidContext()) }

        single<RetrofitRepositoryInterface>(named(MOVIES_REPO_API)) { RetrofitRepository() }

        single<MoviesRepository>(named(MOVIES_REPO_ROOM)) {
            MoviesRepositoryImpl(
                RoomModule(
                    context = androidContext()
                )
                    .getMovieDao()
            )
        }
        viewModel { DetailViewModel(repository = get(named(MOVIES_REPO_ROOM))) }
        viewModel { FavoriteViewModel(repository = get(named(MOVIES_REPO_ROOM))) }
        viewModel {
            MainFragmentViewModel(
                androidContext(),
                repoRoomMovies = get(named(MOVIES_REPO_ROOM)),
                repoApiMovies = get(named(MOVIES_REPO_API))
            )
        }

    }
}