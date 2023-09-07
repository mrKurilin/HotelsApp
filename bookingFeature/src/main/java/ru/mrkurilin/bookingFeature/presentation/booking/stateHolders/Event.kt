package ru.mrkurilin.bookingFeature.presentation.booking.stateHolders

sealed class Event {

    data object DataLoaded : Event()
}