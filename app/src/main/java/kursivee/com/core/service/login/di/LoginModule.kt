package kursivee.com.core.service.login.di

import kursivee.com.core.service.login.LoginApi
import kursivee.com.core.service.login.LoginRepository
import kursivee.com.core.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit

val loginModule = module {
    single {
        get<Retrofit>().create(LoginApi::class.java)
    }

    single {
        LoginRepository(get(), get())
    }

    viewModel {
        MainViewModel(get(), get())
    }
}