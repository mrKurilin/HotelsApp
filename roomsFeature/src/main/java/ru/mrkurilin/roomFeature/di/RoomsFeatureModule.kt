package ru.mrkurilin.roomFeature.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.mrkurilin.roomFeature.data.HotelRoomsRepositoryImpl
import ru.mrkurilin.roomFeature.data.remote.RoomsApiService
import ru.mrkurilin.roomFeature.domain.repository.RoomsRepository

@Module
interface RoomsFeatureModule {

    @Binds
    fun provideRoomsRepository(roomsRepository: HotelRoomsRepositoryImpl): RoomsRepository

    companion object {
        @Provides
        fun provideHotelsApiService(retrofit: Retrofit): RoomsApiService {
            return retrofit.create(RoomsApiService::class.java)
        }
    }
}