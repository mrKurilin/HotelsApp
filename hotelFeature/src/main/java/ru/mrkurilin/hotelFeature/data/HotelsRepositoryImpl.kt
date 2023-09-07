package ru.mrkurilin.hotelFeature.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.mrkurilin.hotelFeature.domain.model.Hotel
import ru.mrkurilin.hotelFeature.domain.repository.HotelsRepository
import javax.inject.Inject

class HotelsRepositoryImpl @Inject constructor(

) : HotelsRepository {

    override fun getHotels(): Flow<List<Hotel>> {
        return flowOf(emptyList())
    }
}