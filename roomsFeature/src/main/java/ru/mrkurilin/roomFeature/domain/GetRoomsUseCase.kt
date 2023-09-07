package ru.mrkurilin.roomFeature.domain

import kotlinx.coroutines.flow.Flow
import ru.mrkurilin.roomFeature.domain.model.Room
import ru.mrkurilin.roomFeature.domain.repository.RoomsRepository
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val roomsRepository: RoomsRepository
) {

    operator fun invoke(): Flow<List<Room>> {
        return roomsRepository.getRooms()
    }
}