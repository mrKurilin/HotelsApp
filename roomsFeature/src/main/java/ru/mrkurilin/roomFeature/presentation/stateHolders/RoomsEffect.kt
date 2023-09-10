package ru.mrkurilin.roomFeature.presentation.stateHolders

sealed interface RoomsEffect {
    data class GoToBooking(
        val hotelName: String,
        val roomName: String,
    ) : RoomsEffect
}