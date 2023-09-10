package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed class HotelsAction {

    data class ChoiceOfRoomsClicked(
        val hotelName: String
    ) : HotelsAction()
}