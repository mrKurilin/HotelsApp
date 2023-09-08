package ru.mrkurilin.bookingFeature.presentation.booking.stateHolders

import ru.mrkurilin.bookingFeature.domain.model.BuyerInputData

sealed interface BookingAction {

    data object GoToPaymentPressed : BookingAction

    data object AddTouristPressed : BookingAction

    data class BuyerDataChanged(val buyerInputData: BuyerInputData) : BookingAction
}