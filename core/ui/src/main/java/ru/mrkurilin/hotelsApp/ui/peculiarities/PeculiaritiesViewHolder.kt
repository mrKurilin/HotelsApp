package ru.mrkurilin.hotelsApp.ui.peculiarities

import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.hotelsApp.ui.databinding.PeculiaritiesViewHolderBinding

class PeculiaritiesViewHolder(
    private val peculiaritiesViewHolderBinding: PeculiaritiesViewHolderBinding
) : RecyclerView.ViewHolder(
    peculiaritiesViewHolderBinding.root
) {

    fun bind(text: String) {
        peculiaritiesViewHolderBinding.peculiarityTextView.text = text
    }
}