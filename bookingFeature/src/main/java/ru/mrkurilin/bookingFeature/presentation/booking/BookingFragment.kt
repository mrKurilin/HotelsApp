package ru.mrkurilin.bookingFeature.presentation.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponentProvider
import ru.mrkurilin.hotelsApp.bookingFeature.R
import ru.mrkurilin.hotelsApp.di.lazyViewModel
import ru.mrkurilin.hotelsApp.di.requireSubComponentsProvider

class BookingFragment : Fragment() {

    private val bookingViewModel: BookingViewModel by lazyViewModel {
        (requireSubComponentsProvider() as BookingFeatureComponentProvider)
            .provideBookingFeatureComponent().bookingViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }
}