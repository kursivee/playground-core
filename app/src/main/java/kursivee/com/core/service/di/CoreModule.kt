package kursivee.com.core.service.di

import kursivee.com.core.service.session.SessionService
import org.koin.dsl.module.module

val coreModule = module {
    single {
        SessionService()
    }
}

