package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed interface HotelsEvent {

    data object OnResumed : HotelsEvent
}