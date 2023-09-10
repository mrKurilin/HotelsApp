package ru.mrkurilin.roomFeature.presentation

import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import ru.mrkurilin.hotelsApp.roomsFeature.databinding.HotelRoomViewHolderBinding
import ru.mrkurilin.hotelsApp.ui.R
import ru.mrkurilin.hotelsApp.ui.imageSlider.ImageSliderAdapter
import ru.mrkurilin.hotelsApp.ui.peculiarities.PeculiaritiesAdapter
import ru.mrkurilin.roomFeature.domain.model.Room

class HotelRoomViewHolder(
    val hotelRoomViewHolderBinding: HotelRoomViewHolderBinding,
) : RecyclerView.ViewHolder(hotelRoomViewHolderBinding.root) {

    private val peculiaritiesAdapter = PeculiaritiesAdapter()
    private val imageSliderAdapter = ImageSliderAdapter()

    init {
        hotelRoomViewHolderBinding.peculiaritiesRecyclerView.adapter = peculiaritiesAdapter
        with(hotelRoomViewHolderBinding.peculiaritiesRecyclerView.layoutManager) {
            if (this is FlexboxLayoutManager) {
                this.flexDirection = FlexDirection.ROW
            }
        }
        hotelRoomViewHolderBinding.imagesSliderViewpager.adapter = imageSliderAdapter
    }

    fun bind(room: Room) {
        imageSliderAdapter.setItems(room.imageUrls)
        peculiaritiesAdapter.setPeculiarities(room.peculiarities)
        hotelRoomViewHolderBinding.nameTextView.text = room.name
        hotelRoomViewHolderBinding.priceBlock.priceForTextView.text = room.pricePer
        hotelRoomViewHolderBinding.priceBlock.priceTextView.text = itemView.context.getString(
            R.string.price,
            room.price
        )
    }
}