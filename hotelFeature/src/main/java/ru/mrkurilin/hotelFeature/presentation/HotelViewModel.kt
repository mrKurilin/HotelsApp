package ru.mrkurilin.hotelFeature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.mrkurilin.hotelFeature.domain.usecase.GetHotelsUseCase
import ru.mrkurilin.hotelFeature.presentation.stateHolders.Action
import ru.mrkurilin.hotelFeature.presentation.stateHolders.Effect
import ru.mrkurilin.hotelFeature.presentation.stateHolders.State
import javax.inject.Inject

class HotelViewModel @Inject constructor(
    private val getHotelsUseCase: GetHotelsUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state: StateFlow<State> = _state.asStateFlow()

    private val _effectFlow: Channel<Effect> = Channel(Channel.BUFFERED)
    val effectFlow = _effectFlow.receiveAsFlow()

    init {
        viewModelScope.launch {
            getHotelsUseCase().collect { list ->
                _state.emit(State.Loaded(list))
            }
        }
    }

    fun onAction(action: Action) {
        viewModelScope.launch {
            when (action) {
                Action.ChoiceOfRoomsClicked -> {
                    _effectFlow.send(Effect.GoToChoiceOfRooms)
                }
            }
        }
    }
}