package kursivee.com.login.ui

import kursivee.com.login.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LoginModule {
    val modules = module {
        viewModel {
            MainViewModel(get())
        }
    }
}