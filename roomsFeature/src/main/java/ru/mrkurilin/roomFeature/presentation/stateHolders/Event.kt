package ru.mrkurilin.roomFeature.presentation.stateHolders

sealed class Event {

    data object DataLoaded : Event()
}