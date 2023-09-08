package ru.mrkurilin.hotelFeature.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.hotelFeature.domain.model.Hotel
import ru.mrkurilin.hotelFeature.presentation.stateHolders.Action
import ru.mrkurilin.hotelFeature.presentation.viewHolders.HotelViewHolder
import ru.mrkurilin.hotelsApp.hotelFeature.databinding.HotelViewHolderBinding
import ru.mrkurilin.hotelsApp.ui.views.GenericDiffUtilCallback

class HotelsAdapter(
    private val onAction: (Action) -> Unit
) : RecyclerView.Adapter<HotelViewHolder>() {

    private var hotels = emptyList<Hotel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val hotelViewHolder = HotelViewHolder(
            binding = HotelViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        hotelViewHolder.binding.chooseRoomButton.setOnClickListener {
            onAction(Action.ChoiceOfRoomsClicked)
        }
        return hotelViewHolder
    }

    override fun getItemCount(): Int = hotels.size

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(hotels[position])
    }

    fun updateHotels(hotels: List<Hotel>) {
        val diffResult = DiffUtil.calculateDiff(
            GenericDiffUtilCallback(this.hotels, hotels)
        )
        this.hotels = hotels
        diffResult.dispatchUpdatesTo(this)
    }
}