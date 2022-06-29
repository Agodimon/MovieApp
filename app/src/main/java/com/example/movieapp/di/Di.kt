package com.example.movieapp.di

import com.example.movieapp.data.room.MoviesRoomDatabase
import com.example.movieapp.data.room.dao.MoviesDao
import com.example.movieapp.data.room.dao.MoviesDao_Impl
import com.example.movieapp.data.room.repository.MoviesRepository
import com.example.movieapp.data.room.repository.MoviesRepositoryImpl
import com.example.movieapp.di.modules.RoomModule
import com.example.movieapp.di.modules.RoomModuleInt
import com.example.movieapp.screens.detail.DetailViewModel
import com.example.movieapp.screens.favorite.FavoriteViewModel
import com.example.movieapp.screens.main.MainFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module
import kotlin.math.sin

object Di {
    private const val MOVIES_REPO = "MOVIES_REPO"
    const val MOVIES_DAO = "MOVIES_DAO"
    val mainModule = module {

        single<MoviesRepository>(named(MOVIES_REPO)) {
            MoviesRepositoryImpl(
                RoomModule(
                    context = androidContext()
                )
                    .getMovieDao()
            )
        }
        viewModel { DetailViewModel(repository = get(named(MOVIES_REPO)))}
        viewModel { FavoriteViewModel(repository = get(named(MOVIES_REPO)))}
        viewModel { MainFragmentViewModel(androidContext(),repo = get(named(MOVIES_REPO)))}

    }
}