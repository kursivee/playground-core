package kursivee.com.core.service.data.di

import kursivee.com.core.service.data.DataApi
import kursivee.com.core.service.data.DataRepository
import org.koin.dsl.module.module
import retrofit2.Retrofit

val dataModule = module {
    single {
        get<Retrofit>().create(DataApi::class.java)
    }

    single {
        DataRepository(get())
    }
}