package ru.mrkurilin.roomFeature.data.remote

import retrofit2.http.GET
import ru.mrkurilin.roomFeature.data.remote.model.RoomsResponse

interface RoomsApiService {

    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRooms(): RoomsResponse
}