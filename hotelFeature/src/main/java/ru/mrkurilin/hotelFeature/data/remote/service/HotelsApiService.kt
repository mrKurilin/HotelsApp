package ru.mrkurilin.hotelFeature.data.remote.service

import retrofit2.http.GET
import ru.mrkurilin.hotelFeature.data.remote.model.HotelResponse

interface HotelsApiService {

    @GET("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotels(): HotelResponse
}