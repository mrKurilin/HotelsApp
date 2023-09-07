package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed class Action {

    data object ChoiceOfRoomsClicked : Action()
}