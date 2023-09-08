package ru.mrkurilin.hotelsapp

import android.app.Application
import ru.mrkurilin.hotelsApp.di.SubComponentsProvider
import ru.mrkurilin.hotelsApp.di.SubComponentsProviderProvider
import ru.mrkurilin.hotelsapp.di.AppComponent
import ru.mrkurilin.hotelsapp.di.DaggerAppComponent
import ru.mrkurilin.hotelsapp.di.SubComponentsProviderImpl

class HotelsApp : Application(), SubComponentsProviderProvider {

    private lateinit var appComponent: AppComponent
    private lateinit var subComponentsProviderImpl: SubComponentsProvider

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(
            context = this
        )
        subComponentsProviderImpl = SubComponentsProviderImpl(appComponent)
    }

    override fun getSubComponentsProvider(): SubComponentsProvider {
        return subComponentsProviderImpl
    }
}