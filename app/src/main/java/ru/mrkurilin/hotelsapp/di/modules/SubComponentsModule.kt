package ru.mrkurilin.hotelsapp.di.modules

import dagger.Module
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponent
import ru.mrkurilin.hotelFeature.di.HotelsFeatureComponent
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponent

@Module(
    subcomponents = [
        HotelsFeatureComponent::class,
        RoomsFeatureComponent::class,
        BookingFeatureComponent::class,
    ]
)
class SubComponentsModule