package ru.mrkurilin.bookingFeature.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingData(
    @SerialName("arrival_country") val arrivalCountry: String,
    @SerialName("departure") val departure: String,
    @SerialName("fuel_charge") val fuelCharge: Int,
    @SerialName("horating") val rating: Int,
    @SerialName("hotel_adress") val hotelAddress: String,
    @SerialName("hotel_name") val hotelName: String,
    @SerialName("id") val id: Int,
    @SerialName("number_of_nights") val numberOfNights: Int,
    @SerialName("nutrition") val nutrition: String,
    @SerialName("rating_name") val ratingName: String,
    @SerialName("room") val room: String,
    @SerialName("service_charge") val serviceCharge: Int,
    @SerialName("tour_date_start") val tourDateStart: String,
    @SerialName("tour_date_stop") val tourDateStop: String,
    @SerialName("tour_price") val tourPrice: Int,
)