package ru.mrkurilin.bookingFeature.presentation.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.mrkurilin.bookingFeature.data.remote.BookingApiService
import ru.mrkurilin.bookingFeature.domain.model.Buyer
import ru.mrkurilin.bookingFeature.domain.model.BuyerInputData
import ru.mrkurilin.bookingFeature.domain.model.Tourist
import ru.mrkurilin.bookingFeature.presentation.booking.stateHolders.BookingAction
import ru.mrkurilin.bookingFeature.presentation.booking.stateHolders.BookingEffect
import ru.mrkurilin.bookingFeature.presentation.booking.stateHolders.BookingState
import javax.inject.Inject

class BookingViewModel @Inject constructor(
    private val bookingApiService: BookingApiService,
) : ViewModel() {

    private val _state: MutableStateFlow<BookingState> = MutableStateFlow(BookingState.Loading)
    val state: StateFlow<BookingState> = _state.asStateFlow()

    private val _effectFlow: Channel<BookingEffect> = Channel(Channel.BUFFERED)
    val effectFlow = _effectFlow.receiveAsFlow()

    private val _buyerInfo: MutableStateFlow<Buyer> = MutableStateFlow(Buyer())
    val buyerInfoFlow: StateFlow<Buyer> = _buyerInfo.asStateFlow()

    private val _tourists: MutableStateFlow<List<Tourist>> =
        MutableStateFlow(listOf(Tourist(0)))
    val touristsFlow: StateFlow<List<Tourist>> = _tourists.asStateFlow()

    fun loadData() {
        viewModelScope.launch {
            _state.emit(BookingState.Loaded(bookingApiService.getBookingData()))
        }
    }

    fun onAction(bookingAction: BookingAction) {
        viewModelScope.launch {
            when (bookingAction) {
                BookingAction.AddTouristPressed -> {
                    _tourists.value = _tourists.value + Tourist(_tourists.value.size)
                }

                BookingAction.GoToPaymentPressed -> {
                    launch { _state.emit(BookingState.Loading) }
                    launch { _effectFlow.send(BookingEffect.GoToPayment) }
                }

                is BookingAction.BuyerDataChanged -> {
                    updateBuyerData(bookingAction.buyerInputData)
                }
            }
        }
    }

    private fun updateBuyerData(buyerInputData: BuyerInputData) {
        when (buyerInputData) {
            is BuyerInputData.Email -> {
                _buyerInfo.value = _buyerInfo.value.copy(email = buyerInputData.value)
            }

            is BuyerInputData.Phone -> {
                _buyerInfo.value = _buyerInfo.value.copy(phoneNumber = buyerInputData.value)
            }
        }
    }
}