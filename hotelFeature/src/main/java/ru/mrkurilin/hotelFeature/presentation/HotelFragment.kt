package ru.mrkurilin.hotelFeature.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import ru.mrkurilin.hotelFeature.presentation.adapters.HotelsAdapter
import ru.mrkurilin.hotelFeature.presentation.stateHolders.Effect
import ru.mrkurilin.hotelFeature.presentation.stateHolders.State
import ru.mrkurilin.hotelsApp.hotelFeature.R

class HotelFragment : Fragment(R.layout.fragment_hotel) {

    private val hotelViewModel by viewModels<HotelViewModel>()

    private lateinit var hotelsRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val hotelsAdapter = HotelsAdapter()

    override fun onResume() {
        super.onResume()
        requireActivity().actionBar?.title = getString(R.string.hotel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hotelsRecyclerView = requireView().findViewById(R.id.hotels_recycler_view)
        progressBar = requireView().findViewById(R.id.progress_bar)

        hotelsRecyclerView.adapter = hotelsAdapter

        lifecycleScope.launch {
            observeState()
            observeEffect()
        }
    }

    private suspend fun observeEffect() {
        hotelViewModel.effectFlow.collect { effect ->
            when (effect) {
                Effect.GoToChoiceOfRooms -> {

                }
            }
        }
    }

    private suspend fun observeState() {
        hotelViewModel.state.collect { state ->
            when (state) {
                is State.Loaded -> {
                    hotelsAdapter.updateHotels(state.hotels)
                    progressBar.visibility = View.GONE
                    hotelsRecyclerView.visibility = View.VISIBLE
                }
                State.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    hotelsRecyclerView.visibility = View.GONE
                }
            }
        }
    }
}