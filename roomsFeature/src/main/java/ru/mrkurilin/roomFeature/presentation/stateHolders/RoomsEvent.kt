package ru.mrkurilin.roomFeature.presentation.stateHolders

sealed class RoomsEvent {

    data object DataLoaded : RoomsEvent()
}