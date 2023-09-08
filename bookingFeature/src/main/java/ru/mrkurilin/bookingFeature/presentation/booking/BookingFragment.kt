package ru.mrkurilin.bookingFeature.presentation.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.mrkurilin.bookingFeature.di.BookingFeatureComponentProvider
import ru.mrkurilin.bookingFeature.domain.model.BookingData
import ru.mrkurilin.bookingFeature.domain.model.BuyerInputData
import ru.mrkurilin.bookingFeature.presentation.booking.stateHolders.BookingAction
import ru.mrkurilin.bookingFeature.presentation.booking.stateHolders.BookingEffect
import ru.mrkurilin.bookingFeature.presentation.booking.stateHolders.BookingState
import ru.mrkurilin.hotelsApp.bookingFeature.R
import ru.mrkurilin.hotelsApp.bookingFeature.databinding.FragmentBookingBinding
import ru.mrkurilin.hotelsApp.di.lazyViewModel
import ru.mrkurilin.hotelsApp.di.requireSubComponentsProvider
import ru.mrkurilin.navigation.navigate

class BookingFragment : Fragment(R.layout.fragment_booking) {

    private val bookingViewModel: BookingViewModel by lazyViewModel {
        (requireSubComponentsProvider() as BookingFeatureComponentProvider)
            .provideBookingFeatureComponent()
            .bookingViewModel()
    }

    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!

    private lateinit var touristsAdapter: TouristsAdapter

    override fun onResume() {
        super.onResume()
        requireActivity().actionBar?.title = getString(R.string.booking)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        touristsAdapter = TouristsAdapter()

        binding.touristsRecyclerView.adapter = touristsAdapter

        binding.bookingAddUserBlock.addTouristButton.setOnClickListener {
            bookingViewModel.onAction(BookingAction.AddTouristPressed)
        }

        binding.bookingBuyerInfoBlock.phoneTextField.doOnTextChanged { text, _, _, _ ->
            bookingViewModel.onAction(
                BookingAction.BuyerDataChanged(BuyerInputData.Phone(text.toString()))
            )
        }
        binding.bookingBuyerInfoBlock.emailTextField.doOnTextChanged { text, _, _, _ ->
            bookingViewModel.onAction(
                BookingAction.BuyerDataChanged(BuyerInputData.Email(text.toString()))
            )
        }

        binding.goToPaymentButton.setOnClickListener {
            bookingViewModel.onAction(BookingAction.GoToPaymentPressed)
        }

        lifecycleScope.launch {
            launch { observeState() }
            launch { observeEffect() }
            launch { observeBuyerInfo() }
            launch { observeTourists() }
            launch { observePaymentInfo() }
        }
    }

    private suspend fun observePaymentInfo() {
        bookingViewModel.touristsFlow.combine(bookingViewModel.state) { tourists, state ->
            if (state !is BookingState.Loaded) {
                return@combine
            }

            val tourPrice = tourists.count() * state.bookingData.tourPrice
            val fuelChargePrice = tourists.count() * state.bookingData.fuelCharge
            val serviceChargePrice = tourists.count() * state.bookingData.serviceCharge
            val totalPrice = tourPrice + fuelChargePrice + serviceChargePrice

            binding.bookingPaymentInfoBlock.tourPriceTextView.text = getString(
                R.string.price, tourPrice
            )
            binding.bookingPaymentInfoBlock.fuelChargeTextView.text = getString(
                R.string.price, fuelChargePrice
            )
            binding.bookingPaymentInfoBlock.serviceChargeTextView.text = getString(
                R.string.price, serviceChargePrice
            )
            binding.bookingPaymentInfoBlock.totalTextView.text = getString(
                R.string.price, totalPrice
            )

            binding.goToPaymentButton.text = getString(R.string.to_pay_price, totalPrice)
        }.collect()
    }

    private suspend fun observeTourists() {
        bookingViewModel.touristsFlow.collect { tourists ->
            touristsAdapter.setItems(tourists)
        }
    }

    private suspend fun observeBuyerInfo() {
        bookingViewModel.buyerInfoFlow.collect { buyer ->
            binding.bookingBuyerInfoBlock.phoneTextField.setText(buyer.phoneNumber)
            binding.bookingBuyerInfoBlock.emailTextField.setText(buyer.email)
        }
    }

    private suspend fun observeEffect() {
        bookingViewModel.effectFlow.collect { effect ->
            when (effect) {
                BookingEffect.GoToPayment -> {
                    navigate(R.id.action_bookingFragment_to_paymentFragment)
                }
            }
        }
    }

    private suspend fun observeState() {
        bookingViewModel.state.collect { state ->
            when (state) {
                is BookingState.Loaded -> {
                    binding.bookingInfoBlockProgressBar.visibility = View.GONE
                    binding.bookingHeaderBlock.root.visibility = View.VISIBLE
                    binding.bookingInfoBlock.root.visibility = View.VISIBLE
                    binding.goToPaymentButton.visibility = View.VISIBLE
                    binding.bookingPaymentInfoBlock.root.visibility = View.VISIBLE

                    bindBookingInfo(state.bookingData)
                }

                BookingState.Loading -> {
                    binding.bookingInfoBlockProgressBar.visibility = View.VISIBLE
                    binding.bookingHeaderBlock.root.visibility = View.GONE
                    binding.bookingInfoBlock.root.visibility = View.GONE
                    binding.goToPaymentButton.visibility = View.GONE
                    binding.bookingPaymentInfoBlock.root.visibility = View.GONE
                }
            }
        }
    }

    private fun bindBookingInfo(bookingData: BookingData) {
        binding.bookingHeaderBlock.ratingView.setRating(bookingData.rating, bookingData.ratingName)
        binding.bookingHeaderBlock.hotelNameTextView.text = bookingData.hotelName
        binding.bookingHeaderBlock.hotelAdressTextView.text = bookingData.hotelAddress

        binding.bookingInfoBlock.departureFromTextView.text = bookingData.departure
        binding.bookingInfoBlock.countryCityTextView.text = bookingData.arrivalCountry
        binding.bookingInfoBlock.datesTextView.text = getString(
            R.string.tour_dates,
            bookingData.tourDateStart,
            bookingData.tourDateStop,
        )
        binding.bookingInfoBlock.nightsCountTextView.text = getString(
            R.string.nights_count_data, bookingData.numberOfNights
        )
        binding.bookingInfoBlock.hotelNameTextView.text = bookingData.hotelName
        binding.bookingInfoBlock.roomNameTextView.text = bookingData.room
        binding.bookingInfoBlock.nutritionTextView.text = bookingData.nutrition
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}