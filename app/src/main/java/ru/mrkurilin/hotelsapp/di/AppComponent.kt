package ru.mrkurilin.hotelsapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponent
import ru.mrkurilin.hotelFeature.di.HotelsFeatureComponent
import ru.mrkurilin.hotelsApp.di.AppScope
import ru.mrkurilin.hotelsApp.di.ApplicationContext
import ru.mrkurilin.hotelsapp.di.modules.NetworkModule
import ru.mrkurilin.hotelsapp.di.modules.SubComponentsModule
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponent

@AppScope
@Component(
    modules = [
        SubComponentsModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context,
        ): AppComponent
    }

    fun hotelsFeatureComponentFactory(): HotelsFeatureComponent.Factory
    fun roomsFeatureComponentFactory(): RoomsFeatureComponent.Factory
    fun bookingFeatureComponentFactory(): BookingFeatureComponent.Factory
}