package com.example.testapp.di

import com.example.testapp.screens.mainScreen.MainScreenVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainScreenVM(get()) }
}