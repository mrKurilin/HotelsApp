package ru.mrkurilin.bookingFeature.presentation.booking

import androidx.fragment.app.Fragment
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponentProvider
import ru.mrkurilin.hotelsApp.bookingFeature.R
import ru.mrkurilin.hotelsApp.di.lazyViewModel
import ru.mrkurilin.hotelsApp.di.requireSubComponentsProvider

class BookingFragment : Fragment(R.layout.fragment_booking) {

    private val bookingViewModel: BookingViewModel by lazyViewModel {
        (requireSubComponentsProvider() as BookingFeatureComponentProvider)
            .provideBookingFeatureComponent().bookingViewModel()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().actionBar?.title = getString(R.string.booking)
    }
}