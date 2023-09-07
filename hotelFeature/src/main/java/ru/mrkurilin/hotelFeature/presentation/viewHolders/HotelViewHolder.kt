package ru.mrkurilin.hotelFeature.presentation.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import ru.mrkurilin.hotelFeature.domain.model.Hotel
import ru.mrkurilin.hotelFeature.presentation.adapters.PeculiaritiesAdapter
import ru.mrkurilin.hotelsApp.hotelFeature.databinding.HotelViewHolderBinding

class HotelViewHolder(
    private val binding: HotelViewHolderBinding,
) : RecyclerView.ViewHolder(binding.root) {

    private val peculiaritiesAdapter = PeculiaritiesAdapter()

    init {
        binding.aboutHotelBlock.peculiaritiesRecyclerView.adapter = peculiaritiesAdapter
        with(binding.aboutHotelBlock.peculiaritiesRecyclerView.layoutManager) {
            if (this is FlexboxLayoutManager) {
                this.flexDirection = FlexDirection.ROW
            }
        }
    }

    fun bind(hotel: Hotel) {
        binding.hotelHeaderBlock.ratingView.setRating(hotel.rating, hotel.ratingName)
        binding.hotelHeaderBlock.hotelName.text = hotel.name
        binding.hotelHeaderBlock.addressTextView.text = hotel.address
        binding.priceBlock.priceTextView.text = hotel.minimalPrice.toString()
        binding.priceBlock.priceForTextView.text = hotel.priceForIt
        peculiaritiesAdapter.setPeculiarities(hotel.peculiarities)
        binding.aboutHotelBlock.descriptionTextView.text = hotel.description
    }
}