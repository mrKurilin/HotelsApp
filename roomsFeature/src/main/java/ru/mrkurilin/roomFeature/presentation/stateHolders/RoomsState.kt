package ru.mrkurilin.roomFeature.presentation.stateHolders

import ru.mrkurilin.roomFeature.domain.model.Room

sealed interface RoomsState {

    data object Loading : RoomsState

    data class Loaded(
        val rooms: List<Room>
    ) : RoomsState
}