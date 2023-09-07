package ru.mrkurilin.hotelFeature.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AboutTheHotel(
    @SerialName("description")
    val description: String,
    @SerialName("peculiarities")
    val peculiarities: List<String>
)