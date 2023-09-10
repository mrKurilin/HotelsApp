package ru.mrkurilin.roomFeature.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import ru.mrkurilin.hotelsApp.di.lazyViewModel
import ru.mrkurilin.hotelsApp.di.requireSubComponentsProvider
import ru.mrkurilin.hotelsApp.roomsFeature.R
import ru.mrkurilin.navigation.navigate
import ru.mrkurilin.navigation.navigationData
import ru.mrkurilin.roomFeature.di.RoomsFeatureComponentProvider
import ru.mrkurilin.roomFeature.presentation.stateHolders.RoomsEffect
import ru.mrkurilin.roomFeature.presentation.stateHolders.RoomsState

class RoomsFragment : Fragment(R.layout.fragment_rooms) {

    private val roomsViewModel: RoomsViewModel by lazyViewModel {
        (requireSubComponentsProvider() as RoomsFeatureComponentProvider)
            .provideRoomsFeatureComponent().roomsViewModel()
    }

    private lateinit var roomsRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var hotelRoomsAdapter: HotelRoomsAdapter

    override fun onResume() {
        super.onResume()
        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.title = getString(R.string.rooms)
        activity.supportActionBar?.setDisplayShowHomeEnabled(true)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        roomsViewModel.loadHotelRooms(navigationData as? String)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hotelRoomsAdapter = HotelRoomsAdapter(
            onAction = (roomsViewModel::onAction)
        )

        roomsRecyclerView = requireView().findViewById(R.id.rooms_recycler_view)
        progressBar = requireView().findViewById(R.id.progress_bar)

        roomsRecyclerView.adapter = hotelRoomsAdapter

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
        roomsViewModel.effectFlow.collect { effect ->
            when (effect) {
                is RoomsEffect.GoToBooking -> {
                    navigate(
                        actionId = R.id.action_roomsFragment_to_bookingFragment,
                        data = arrayOf(effect.hotelName, effect.roomName)
                    )
                }
            }
        }
    }

    private suspend fun observeState() {
        roomsViewModel.state.collect { state ->
            when (state) {
                is RoomsState.Loaded -> {
                    hotelRoomsAdapter.setItems(state.rooms)
                    progressBar.visibility = View.GONE
                    roomsRecyclerView.visibility = View.VISIBLE
                }

                RoomsState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    roomsRecyclerView.visibility = View.GONE
                }
            }
        }
    }
}