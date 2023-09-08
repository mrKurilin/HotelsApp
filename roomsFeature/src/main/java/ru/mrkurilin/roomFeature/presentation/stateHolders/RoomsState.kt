package ru.mrkurilin.roomFeature.presentation.stateHolders

sealed class RoomsState {
    data object Loading : RoomsState()

    data class Loaded(
        val name: String
    ) : RoomsState()
}