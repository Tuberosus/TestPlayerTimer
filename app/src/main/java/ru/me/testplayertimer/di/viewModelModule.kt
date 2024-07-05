package ru.me.testplayertimer.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.me.testplayertimer.presentation.PlayerViewModel

val viewModelModule = module {
    viewModel {
        PlayerViewModel()
    }
}