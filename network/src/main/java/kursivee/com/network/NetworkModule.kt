package kursivee.com.network

import org.koin.dsl.module

object NetworkModule {
    val modules = module {
        single {
            Network.getRetrofit("https://www.mocky.io/v2/", get())
        }
        single {
            SessionService()
        }
    }
}