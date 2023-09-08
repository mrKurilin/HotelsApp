package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed class Action {

    data class ChoiceOfRoomsClicked(
        val hotelName: String
    ) : Action()
}