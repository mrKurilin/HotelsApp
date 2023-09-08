package ru.mrkurilin.roomFeature.data.remote.model

import kotlinx.serialization.Serializable
import ru.mrkurilin.roomFeature.domain.model.Room

@Serializable
data class RoomsResponse(
    val rooms: List<Room>
)