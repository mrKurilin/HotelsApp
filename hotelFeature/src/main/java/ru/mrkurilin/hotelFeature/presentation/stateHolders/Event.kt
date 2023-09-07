package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed class Event {

    data object DataLoaded : Event()
}