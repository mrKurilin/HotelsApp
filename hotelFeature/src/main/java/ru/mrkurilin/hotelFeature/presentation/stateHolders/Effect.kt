package ru.mrkurilin.hotelFeature.presentation.stateHolders

sealed class Effect {

    data object GoToChoiceOfRooms : Effect()
}