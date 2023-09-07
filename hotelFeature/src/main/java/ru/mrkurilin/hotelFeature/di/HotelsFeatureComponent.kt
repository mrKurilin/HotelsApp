package ru.mrkurilin.hotelFeature.di

import dagger.Subcomponent
import ru.mrkurilin.hotelFeature.presentation.HotelsViewModel

@Subcomponent(
    modules = [
        HotelsFeatureModule::class
    ]
)
interface HotelsFeatureComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): HotelsFeatureComponent
    }

    fun hotelsViewModel(): HotelsViewModel
}