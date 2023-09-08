package ru.mrkurilin.roomFeature.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Room(
    @SerialName("id") val id: Int,
    @SerialName("image_urls") val imageUrls: List<String>,
    @SerialName("name") val name: String,
    @SerialName("peculiarities") val peculiarities: List<String>,
    @SerialName("price") val price: Int,
    @SerialName("price_per") val pricePer: String,
)