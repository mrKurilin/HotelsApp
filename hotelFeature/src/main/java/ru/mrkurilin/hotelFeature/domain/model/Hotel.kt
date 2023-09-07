package ru.mrkurilin.hotelFeature.domain.model

data class Hotel(
    val address: String,
    val id: Int,
    val imageUrls: List<String>,
    val minimalPrice: Int,
    val name: String,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val description: String,
    val peculiarities: List<String>,
)