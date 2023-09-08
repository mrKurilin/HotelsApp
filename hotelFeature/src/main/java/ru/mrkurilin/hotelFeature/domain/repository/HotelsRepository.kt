package ru.mrkurilin.hotelFeature.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.mrkurilin.hotelFeature.domain.model.Hotel

interface HotelsRepository {

    suspend fun getHotels(): Flow<List<Hotel>>
}