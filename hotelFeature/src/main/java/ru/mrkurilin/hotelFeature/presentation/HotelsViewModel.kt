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
import ru.mrkurilin.hotelFeature.presentation.stateHolders.HotelsAction
import ru.mrkurilin.hotelFeature.presentation.stateHolders.HotelsEffect
import ru.mrkurilin.hotelFeature.presentation.stateHolders.HotelsEvent
import ru.mrkurilin.hotelFeature.presentation.stateHolders.HotelsState
import javax.inject.Inject

class HotelsViewModel @Inject constructor(
    private val getHotelsUseCase: GetHotelsUseCase,
) : ViewModel() {

    private val _hotelsState: MutableStateFlow<HotelsState> = MutableStateFlow(HotelsState.Loading)
    val hotelsState: StateFlow<HotelsState> = _hotelsState.asStateFlow()

    private val _hotelsEffectFlow: Channel<HotelsEffect> = Channel(Channel.BUFFERED)
    val effectFlow = _hotelsEffectFlow.receiveAsFlow()

    fun onAction(hotelsAction: HotelsAction) {
        viewModelScope.launch {
            when (hotelsAction) {
                is HotelsAction.ChoiceOfRoomsClicked -> {
                    _hotelsState.emit(HotelsState.Loading)
                    _hotelsEffectFlow.send(HotelsEffect.GoToChoiceOfRooms(hotelsAction.hotelName))
                }
            }
        }
    }

    fun onEvent(hotelsEvent: HotelsEvent) {
        viewModelScope.launch {
            when (hotelsEvent) {
                HotelsEvent.OnResumed -> {
                    getHotelsUseCase().collect { list ->
                        _hotelsState.emit(HotelsState.Loaded(list))
                    }
                }
            }
        }
    }
}