package kursivee.com.feature_data

import org.koin.dsl.module
import retrofit2.Retrofit

object FeatureDataModule {
    val modules = module {
        single {
            get<Retrofit>().create(FeatureApi::class.java)
        }
    }
}