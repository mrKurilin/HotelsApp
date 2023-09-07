package ru.mrkurilin.hotelFeature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.mrkurilin.hotelsApp.hotelFeature.R

class HotelFragment : Fragment() {

    private val hotelModel by viewModels<HotelViewModel>()

    override fun onResume() {
        super.onResume()
        requireActivity().actionBar?.title = "Title"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel, container, false)
    }
}