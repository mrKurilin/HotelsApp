package ru.mrkurilin.hotelsapp.di

import ru.mrkurilin.bookingFeature.di.BookingFeatureComponent
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponentProvider
import ru.mrkurilin.hotelFeature.di.HotelsFeatureComponent
import ru.mrkurilin.hotelFeature.di.HotelsFeatureComponentProvider
import ru.mrkurilin.hotelsApp.di.SubComponentsProvider
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponent
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponentProvider

class SubComponentsProviderImpl(
    private val appComponent: AppComponent
) : SubComponentsProvider,
    HotelsFeatureComponentProvider,
    RoomsFeatureComponentProvider,
    BookingFeatureComponentProvider {

    override fun provideBookingFeatureComponent(): BookingFeatureComponent {
        return appComponent.bookingFeatureComponentFactory().create()
    }

    override fun provideHotelsFeatureComponent(): HotelsFeatureComponent {
        return appComponent.hotelsFeatureComponentFactory().create()
    }

    override fun provideRoomsFeatureComponent(): RoomsFeatureComponent {
        return appComponent.roomsFeatureComponentFactory().create()
    }
}