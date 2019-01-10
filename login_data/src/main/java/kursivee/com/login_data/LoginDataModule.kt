package kursivee.com.login_data

import org.koin.dsl.module
import retrofit2.Retrofit

object LoginDataModule {
    val modules = module {
        single {
            get<Retrofit>().create(LoginApi::class.java)
        }

        single {
            LoginRepository(get(), get())
        }
    }
}