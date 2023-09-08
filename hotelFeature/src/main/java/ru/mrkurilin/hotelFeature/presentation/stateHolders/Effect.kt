package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed class Effect {

    data class GoToChoiceOfRooms(
        val hotelName: String
    ) : Effect()

    data object Idle: Effect()
}