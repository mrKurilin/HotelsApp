package ru.mrkurilin.hotelFeature.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotelResponse(
    @SerialName("about_the_hotel")
    val aboutTheHotel: AboutTheHotel,
    @SerialName("adress")
    val address: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image_urls")
    val imageUrls: List<String>,
    @SerialName("minimal_price")
    val minimalPrice: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price_for_it")
    val priceForIt: String,
    @SerialName("rating")
    val rating: Int,
    @SerialName("rating_name")
    val ratingName: String
)