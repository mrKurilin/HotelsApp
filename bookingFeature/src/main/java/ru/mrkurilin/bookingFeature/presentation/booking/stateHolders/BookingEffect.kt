package ru.mrkurilin.bookingFeature.presentation.booking.stateHolders

sealed interface BookingEffect {

    data object GoToPayment : BookingEffect

    data object ShowEmptyFieldsError : BookingEffect
}