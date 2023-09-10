package ru.mrkurilin.hotelFeature.presentation.stateHolders

import ru.mrkurilin.hotelFeature.domain.model.Hotel

sealed class HotelsState {

    data object Loading : HotelsState()

    data class Loaded(val hotels: List<Hotel>) : HotelsState()
}