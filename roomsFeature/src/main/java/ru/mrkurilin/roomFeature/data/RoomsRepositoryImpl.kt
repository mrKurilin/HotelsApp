package ru.mrkurilin.roomFeature.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.mrkurilin.roomFeature.domain.model.Room
import ru.mrkurilin.roomFeature.domain.repository.RoomsRepository
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(

) : RoomsRepository {

    override fun getRooms(): Flow<List<Room>> {
        return flowOf(emptyList())
    }
}