package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed class HotelsEffect {

    data class GoToChoiceOfRooms(
        val hotelName: String
    ) : HotelsEffect()
}