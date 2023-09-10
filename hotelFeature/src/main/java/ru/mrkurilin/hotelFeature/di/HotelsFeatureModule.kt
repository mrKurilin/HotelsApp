package ru.mrkurilin.hotelFeature.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.mrkurilin.hotelFeature.data.HotelsRepositoryImpl
import ru.mrkurilin.hotelFeature.data.remote.service.HotelsApiService
import ru.mrkurilin.hotelFeature.domain.repository.HotelsRepository

@Module
interface HotelsFeatureModule {

    @Binds
    @HotelsFeatureScope
    fun provideHotelsRepository(
        hotelsRepositoryImpl: HotelsRepositoryImpl
    ): HotelsRepository

    companion object {
        @Provides
        @HotelsFeatureScope
        fun provideHotelsApiService(retrofit: Retrofit): HotelsApiService {
            return retrofit.create(HotelsApiService::class.java)
        }
    }
}