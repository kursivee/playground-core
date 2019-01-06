package kursivee.com.core.service.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kursivee.com.core.service.session.SessionService
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://www.mocky.io/v2/"

val networkModule = module {
    single {
        val sessionService = get<SessionService>()
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor {
            val original = it.request()
            val requestBuilder = original.newBuilder()
                .method(original.method(), original.body())
            if(sessionService.sessionToken != "") {
                requestBuilder.header("token", sessionService.sessionToken)
            }
            it.proceed(requestBuilder.build())
        }
        return@single httpClient.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}