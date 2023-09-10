package ru.mrkurilin.hotelsApp.ui.peculiarities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.hotelsApp.ui.databinding.PeculiaritiesViewHolderBinding
import ru.mrkurilin.hotelsApp.ui.views.GenericDiffUtilCallback

class PeculiaritiesAdapter : RecyclerView.Adapter<PeculiaritiesViewHolder>() {

    private var peculiarities = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeculiaritiesViewHolder {
        return PeculiaritiesViewHolder(
            peculiaritiesViewHolderBinding = PeculiaritiesViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = peculiarities.size

    override fun onBindViewHolder(holder: PeculiaritiesViewHolder, position: Int) {
        holder.bind(peculiarities[position])
    }

    fun setPeculiarities(peculiarities: List<String>) {
        val diffResult = DiffUtil.calculateDiff(
            GenericDiffUtilCallback(this.peculiarities, peculiarities)
        )
        this.peculiarities = peculiarities
        diffResult.dispatchUpdatesTo(this)
    }
}