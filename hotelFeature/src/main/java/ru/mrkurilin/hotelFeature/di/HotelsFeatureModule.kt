package ru.mrkurilin.hotelFeature.di

import dagger.Binds
import dagger.Module
import ru.mrkurilin.hotelFeature.data.HotelsRepositoryImpl
import ru.mrkurilin.hotelFeature.domain.repository.HotelsRepository

@Module
interface HotelsFeatureModule {

    @Binds
    fun provideHotelsRepository(hotelsRepositoryImpl: HotelsRepositoryImpl): HotelsRepository
}