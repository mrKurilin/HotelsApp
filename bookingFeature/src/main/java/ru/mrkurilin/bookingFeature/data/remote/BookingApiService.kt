package ru.mrkurilin.bookingFeature.data.remote

import retrofit2.http.GET
import ru.mrkurilin.bookingFeature.domain.model.BookingData

interface BookingApiService {

    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBookingData(): BookingData
}