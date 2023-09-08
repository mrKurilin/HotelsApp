package ru.mrkurilin.roomFeature.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.hotelsApp.roomsFeature.databinding.HotelRoomViewHolderBinding
import ru.mrkurilin.hotelsApp.ui.views.GenericDiffUtilCallback
import ru.mrkurilin.roomFeature.domain.model.Room
import ru.mrkurilin.roomFeature.presentation.stateHolders.RoomsAction

class HotelRoomsAdapter(
    private val onAction: (RoomsAction) -> Unit,
) : RecyclerView.Adapter<HotelRoomViewHolder>() {

    private var rooms = emptyList<Room>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelRoomViewHolder {
        val hotelViewHolder = HotelRoomViewHolder(
            hotelRoomViewHolderBinding = HotelRoomViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        hotelViewHolder.hotelRoomViewHolderBinding.goToBookingButton.setOnClickListener {
            onAction(
                RoomsAction.GoToBookingPressed(
                    rooms[hotelViewHolder.adapterPosition].name
                )
            )
        }
        return hotelViewHolder
    }

    override fun getItemCount(): Int = rooms.count()

    override fun onBindViewHolder(holder: HotelRoomViewHolder, position: Int) {
        holder.bind(rooms[position])
    }

    fun setItems(rooms: List<Room>) {
        val diffResult = DiffUtil.calculateDiff(
            GenericDiffUtilCallback(this.rooms, rooms)
        )
        this.rooms = rooms
        diffResult.dispatchUpdatesTo(this)
    }
}