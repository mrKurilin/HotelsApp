package ru.mrkurilin.roomFeature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.mrkurilin.hotelsApp.di.lazyViewModel
import ru.mrkurilin.hotelsApp.di.requireSubComponentsProvider
import ru.mrkurilin.hotelsApp.roomsFeature.R
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponentProvider

class RoomsFragment : Fragment() {

    private val roomsViewModel: RoomsViewModel by lazyViewModel {
        (requireSubComponentsProvider() as RoomsFeatureComponentProvider)
            .provideRoomsFeatureComponent().roomsViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel_room, container, false)
    }
}