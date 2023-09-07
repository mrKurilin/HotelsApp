package ru.mrkurilin.hotelFeature.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.mrkurilin.hotelFeature.domain.model.Hotel

interface HotelsRepository {

    fun getHotels(): Flow<List<Hotel>>
}