package ru.mrkurilin.roomFeature.presentation.stateHolders

sealed interface RoomsAction {

    data class GoToBookingPressed(
        val roomName: String
    ) : RoomsAction
}