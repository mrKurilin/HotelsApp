package ru.mrkurilin.roomFeature.presentation.stateHolders

sealed class State {
    data object Loading : State()

    data class Loaded(
        val name: String
    ) : State()
}