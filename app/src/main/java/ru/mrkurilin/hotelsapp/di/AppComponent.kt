package ru.mrkurilin.hotelsapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponent
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponentProvider
import ru.mrkurilin.hotelFeature.di.HotelsFeatureComponent
import ru.mrkurilin.hotelFeature.di.HotelsFeatureComponentProvider
import ru.mrkurilin.hotelsapp.di.modules.SubComponentsModule
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponent
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponentProvider

@Component(
    modules = [
        SubComponentsModule::class,
    ]
)
interface AppComponent : HotelsFeatureComponentProvider, RoomsFeatureComponentProvider,
    BookingFeatureComponentProvider {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context: Context,
        ): AppComponent
    }

    fun hotelsFeatureComponentFactory(): HotelsFeatureComponent.Factory
    fun roomsFeatureComponentFactory(): RoomsFeatureComponent.Factory
    fun bookingFeatureComponentFactory(): BookingFeatureComponent.Factory
}