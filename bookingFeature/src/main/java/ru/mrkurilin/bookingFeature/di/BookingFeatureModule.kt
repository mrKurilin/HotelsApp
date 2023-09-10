package ru.mrkurilin.bookingFeature.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.mrkurilin.bookingFeature.data.remote.BookingApiService

@Module
interface BookingFeatureModule {

    companion object {

        @Provides
        fun provideBookingApiService(retrofit: Retrofit): BookingApiService {
            return retrofit.create(BookingApiService::class.java)
        }
    }
}