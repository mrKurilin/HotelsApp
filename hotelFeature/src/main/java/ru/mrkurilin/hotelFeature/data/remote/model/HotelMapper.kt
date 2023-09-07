package ru.mrkurilin.hotelFeature.data.remote.model

import ru.mrkurilin.hotelFeature.domain.model.Hotel

class HotelMapper {

    fun map(hotelResponse: HotelResponse): Hotel {
        return Hotel(
            address = hotelResponse.address,
            id = hotelResponse.id,
            imageUrls = hotelResponse.imageUrls,
            minimalPrice = hotelResponse.minimalPrice,
            name = hotelResponse.name,
            priceForIt = hotelResponse.priceForIt,
            rating = hotelResponse.rating,
            ratingName = hotelResponse.ratingName,
            description = hotelResponse.aboutTheHotel.description,
            peculiarities = hotelResponse.aboutTheHotel.peculiarities,
        )
    }
}