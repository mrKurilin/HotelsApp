package ru.mrkurilin.hotelFeature.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import ru.mrkurilin.hotelFeature.data.remote.service.HotelsApiService
import ru.mrkurilin.hotelFeature.di.HotelsFeatureScope
import ru.mrkurilin.hotelFeature.domain.model.Hotel
import ru.mrkurilin.hotelFeature.domain.repository.HotelsRepository
import javax.inject.Inject

@HotelsFeatureScope
class HotelsRepositoryImpl @Inject constructor(
    private val hotelsApiService: HotelsApiService,
) : HotelsRepository {

    override suspend fun getHotels(): Flow<List<Hotel>> {
        return withContext(Dispatchers.IO) {
            flowOf(listOf(hotelsApiService.getHotels().toHotel()))
        }
    }
}