package ru.mrkurilin.bookingFeature.domain.model

data class Tourist(
    val id: Int,
    val name: String = "",
    val secondName: String = "",
    val birthDay: String = "",
    val citizenship: String = "",
    val passportNumber: String = "",
    val passportValidityPeriod: String = "",
)