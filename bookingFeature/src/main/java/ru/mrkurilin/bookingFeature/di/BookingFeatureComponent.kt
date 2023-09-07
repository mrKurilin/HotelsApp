package ru.mrkurilin.bookingFeature.di

import dagger.Subcomponent
import ru.mrkurilin.bookingFeature.presentation.booking.BookingViewModel

@Subcomponent(
    modules = [
        BookingFeatureModule::class
    ]
)
interface BookingFeatureComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): BookingFeatureComponent
    }

    fun bookingViewModel(): BookingViewModel
}