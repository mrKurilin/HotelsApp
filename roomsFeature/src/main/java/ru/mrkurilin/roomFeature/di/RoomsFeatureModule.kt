package ru.mrkurilin.roomFeature.di

import dagger.Binds
import dagger.Module
import ru.mrkurilin.roomFeature.data.RoomsRepositoryImpl
import ru.mrkurilin.roomFeature.domain.repository.RoomsRepository

@Module
interface RoomsFeatureModule {

    @Binds
    fun provideRoomsRepository(hotelsRepositoryImpl: RoomsRepositoryImpl): RoomsRepository
}