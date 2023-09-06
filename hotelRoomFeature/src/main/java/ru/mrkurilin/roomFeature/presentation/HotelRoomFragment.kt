package ru.mrkurilin.roomFeature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.mrkurilin.hotelsApp.hotelRoomFeature.R

class HotelRoomFragment : Fragment() {

    private val hotelRoomModel by viewModels<HotelRoomViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel_room, container, false)
    }
}