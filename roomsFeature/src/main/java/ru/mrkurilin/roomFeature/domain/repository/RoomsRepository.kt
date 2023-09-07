package ru.mrkurilin.roomFeature.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.mrkurilin.roomFeature.domain.model.Room

interface RoomsRepository {

    fun getRooms(): Flow<List<Room>>
}