package ru.mrkurilin.hotelFeature.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.mrkurilin.hotelFeature.domain.model.Hotel
import ru.mrkurilin.hotelFeature.domain.repository.HotelsRepository
import javax.inject.Inject

class GetHotelsUseCase @Inject constructor(
    private val hotelsRepository: HotelsRepository,
) {

    operator fun invoke(): Flow<List<Hotel>> {
        return hotelsRepository.getHotels()
    }
}