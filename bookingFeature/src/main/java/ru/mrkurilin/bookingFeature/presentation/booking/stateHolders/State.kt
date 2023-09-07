package ru.mrkurilin.bookingFeature.presentation.booking.stateHolders

sealed class State {
    data object Loading : State()

    data class Loaded(
        val name: String
    ) : State()
}