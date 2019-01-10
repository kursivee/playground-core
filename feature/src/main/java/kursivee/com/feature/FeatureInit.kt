package kursivee.com.feature

import kursivee.com.feature_data.FeatureDataModule
import org.koin.core.context.loadKoinModules

fun initFeature() = {
    loadKoinModules(FeatureDataModule.modules)
}