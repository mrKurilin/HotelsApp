package ru.mrkurilin.hotelFeature.presentation.viewHolders

import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.hotelsApp.hotelFeature.databinding.PeculiaritiesViewHolderBinding

class PeculiaritiesViewHolder(
    private val peculiaritiesViewHolderBinding: PeculiaritiesViewHolderBinding
) : RecyclerView.ViewHolder(
    peculiaritiesViewHolderBinding.root
) {

    fun bind(text: String) {
        peculiaritiesViewHolderBinding.peculiarityTextView.text = text
    }
}