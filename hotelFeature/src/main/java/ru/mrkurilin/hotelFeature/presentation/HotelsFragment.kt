package ru.mrkurilin.hotelFeature.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import ru.mrkurilin.hotelFeature.di.HotelsFeatureComponentProvider
import ru.mrkurilin.hotelFeature.presentation.adapters.HotelsAdapter
import ru.mrkurilin.hotelFeature.presentation.stateHolders.HotelsEffect
import ru.mrkurilin.hotelFeature.presentation.stateHolders.HotelsEvent
import ru.mrkurilin.hotelFeature.presentation.stateHolders.HotelsState
import ru.mrkurilin.hotelsApp.di.lazyViewModel
import ru.mrkurilin.hotelsApp.di.requireSubComponentsProvider
import ru.mrkurilin.hotelsApp.hotelFeature.R
import ru.mrkurilin.navigation.navigate

class HotelsFragment : Fragment(R.layout.fragment_hotel) {

    private val hotelsViewModel: HotelsViewModel by lazyViewModel {
        (requireSubComponentsProvider() as HotelsFeatureComponentProvider)
            .provideHotelsFeatureComponent().hotelsViewModel()
    }

    private lateinit var hotelsRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var hotelsAdapter: HotelsAdapter

    override fun onResume() {
        super.onResume()
        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.title = getString(R.string.hotel)
        activity.supportActionBar?.setDisplayShowHomeEnabled(false)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        hotelsViewModel.onEvent(HotelsEvent.OnResumed)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hotelsAdapter = HotelsAdapter(
            onAction = (hotelsViewModel::onAction)
        )

        hotelsRecyclerView = requireView().findViewById(R.id.hotels_recycler_view)
        progressBar = requireView().findViewById(R.id.progress_bar)

        hotelsRecyclerView.adapter = hotelsAdapter

        lifecycleScope.launch {
            launch {
                observeState()
            }
            launch {
                observeEffect()
            }
        }
    }

    private suspend fun observeEffect() {
        hotelsViewModel.effectFlow.collect { effect ->
            when (effect) {
                is HotelsEffect.GoToChoiceOfRooms -> {
                    navigate(
                        actionId = R.id.action_hotelsFragment_to_roomsFragment,
                        data = effect.hotelName
                    )
                }
            }
        }
    }

    private suspend fun observeState() {
        hotelsViewModel.hotelsState.collect { state ->
            when (state) {
                is HotelsState.Loaded -> {
                    hotelsAdapter.updateHotels(state.hotels)
                    progressBar.visibility = View.GONE
                    hotelsRecyclerView.visibility = View.VISIBLE
                }

                HotelsState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    hotelsRecyclerView.visibility = View.GONE
                }
            }
        }
    }
}