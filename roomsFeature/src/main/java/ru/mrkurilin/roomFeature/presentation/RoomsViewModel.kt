package ru.mrkurilin.roomFeature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.mrkurilin.roomFeature.domain.GetRoomsUseCase
import ru.mrkurilin.roomFeature.presentation.stateHolders.RoomsAction
import ru.mrkurilin.roomFeature.presentation.stateHolders.RoomsEffect
import ru.mrkurilin.roomFeature.presentation.stateHolders.RoomsState
import javax.inject.Inject

class RoomsViewModel @Inject constructor(
    private val getRoomsUseCase: GetRoomsUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<RoomsState> = MutableStateFlow(RoomsState.Loading)
    val state: StateFlow<RoomsState> = _state.asStateFlow()

    private val _effectFlow: Channel<RoomsEffect> = Channel(Channel.BUFFERED)
    val effectFlow = _effectFlow.receiveAsFlow()

    private lateinit var hotelName: String

    fun loadHotelRooms(hotelName: String?) {
        hotelName ?: return
        this.hotelName = hotelName
        viewModelScope.launch {
            getRoomsUseCase(hotelName).collect { list ->
                _state.emit(RoomsState.Loaded(list))
            }
        }
    }

    fun onAction(roomsAction: RoomsAction) {
        viewModelScope.launch {
            when (roomsAction) {
                is RoomsAction.GoToBookingPressed -> {
                    _effectFlow.send(
                        RoomsEffect.GoToBooking(
                            hotelName = hotelName,
                            roomName = roomsAction.roomName,
                        )
                    )
                }
            }
        }
    }
}