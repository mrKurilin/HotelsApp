package ru.mrkurilin.hotelFeature.presentation.stateHolders

import ru.mrkurilin.hotelFeature.domain.model.Hotel

sealed class State {

    data object Loading : State()

    data class Loaded(val hotels: List<Hotel>) : State()
}