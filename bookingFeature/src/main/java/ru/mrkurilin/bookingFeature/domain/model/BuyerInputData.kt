package ru.mrkurilin.bookingFeature.domain.model

sealed interface BuyerInputData {

    val value: String

    data class Phone(override val value: String) : BuyerInputData
    data class Email(override val value: String) : BuyerInputData
}