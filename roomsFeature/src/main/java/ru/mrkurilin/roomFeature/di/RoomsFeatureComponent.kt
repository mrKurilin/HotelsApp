package ru.mrkurilin.roomFeature.di

import dagger.Subcomponent
import ru.mrkurilin.roomFeature.presentation.RoomsViewModel

@Subcomponent(
    modules = [
        RoomsFeatureModule::class
    ]
)
interface RoomsFeatureComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): RoomsFeatureComponent
    }

    fun roomsViewModel(): RoomsViewModel
}