package ru.mrkurilin.bookingFeature.presentation.booking.stateHolders

import ru.mrkurilin.bookingFeature.domain.model.BookingData

sealed class BookingState {
    data object Loading : BookingState()

    data class Loaded(
        val bookingData: BookingData,
    ) : BookingState()
}