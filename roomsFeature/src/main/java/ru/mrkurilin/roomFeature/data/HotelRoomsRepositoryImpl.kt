package ru.mrkurilin.roomFeature.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import ru.mrkurilin.roomFeature.data.remote.RoomsApiService
import ru.mrkurilin.roomFeature.di.HotelRoomsFeatureScope
import ru.mrkurilin.roomFeature.domain.model.Room
import ru.mrkurilin.roomFeature.domain.repository.RoomsRepository
import javax.inject.Inject

@HotelRoomsFeatureScope
class HotelRoomsRepositoryImpl @Inject constructor(
    private val roomsApiService: RoomsApiService,
) : RoomsRepository {

    override suspend fun getRooms(hotelName: String): Flow<List<Room>> {
        return withContext(Dispatchers.IO) {
            flowOf(roomsApiService.getRooms().rooms)
        }
    }
}