package com.example.movieapp.di

import com.example.movieapp.di.modules.RoomModule
import com.example.movieapp.di.modules.RoomModuleInt
import org.koin.dsl.module

object Di {
    val mainModule = module {
        factory<RoomModuleInt> { RoomModule() }
    }
}