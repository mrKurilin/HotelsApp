package ru.mrkurilin.bookingFeature.presentation.booking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.bookingFeature.domain.model.Tourist
import ru.mrkurilin.hotelsApp.bookingFeature.databinding.TouristViewHolderBinding
import ru.mrkurilin.hotelsApp.ui.views.GenericDiffUtilCallback

class TouristsAdapter : RecyclerView.Adapter<TouristViewHolder>() {

    private var tourists = emptyList<Tourist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristViewHolder {
        return TouristViewHolder(
            touristViewHolderBinding = TouristViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = tourists.count()

    override fun onBindViewHolder(holder: TouristViewHolder, position: Int) {
        holder.bind(tourists[position])
    }

    fun setItems(tourists: List<Tourist>) {
        val sortedTourists = tourists.sortedBy { it.id }
        val diffResult = DiffUtil.calculateDiff(
            GenericDiffUtilCallback(this.tourists, sortedTourists)
        )
        this.tourists = sortedTourists
        diffResult.dispatchUpdatesTo(this)
    }
}