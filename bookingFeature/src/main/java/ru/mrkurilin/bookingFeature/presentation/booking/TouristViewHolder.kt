package ru.mrkurilin.bookingFeature.presentation.booking

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.bookingFeature.domain.model.Tourist
import ru.mrkurilin.hotelsApp.bookingFeature.R
import ru.mrkurilin.hotelsApp.bookingFeature.databinding.TouristViewHolderBinding

class TouristViewHolder(
    private val touristViewHolderBinding: TouristViewHolderBinding,
) : RecyclerView.ViewHolder(touristViewHolderBinding.root) {

    init {
        touristViewHolderBinding.inputToggleButton.setOnClickListener {
            if (touristViewHolderBinding.touristInputBlock.isVisible) {
                touristViewHolderBinding.touristInputBlock.visibility = View.GONE
                touristViewHolderBinding.inputToggleButton.setImageResource(R.drawable.down)
            } else {
                touristViewHolderBinding.touristInputBlock.visibility = View.VISIBLE
                touristViewHolderBinding.inputToggleButton.setImageResource(R.drawable.up)
            }
        }
    }

    fun bind(tourist: Tourist) {
        with(touristViewHolderBinding) {
            val headerText = when (tourist.id) {
                0 -> "Первый турист"
                1 -> "Второй турист"
                2 -> "Третий турист"
                else -> "${tourist.id + 1}й турист"
            }
            touristHeader.text = headerText
            nameTextField.setText(tourist.name)
            secondNameTextField.setText(tourist.secondName)
            birthdayTextField.setText(tourist.birthDay)
            citizenshipTextField.setText(tourist.citizenship)
            passportNumberTextField.setText(tourist.passportNumber)
            passportValidityPeriodTextField.setText(tourist.passportValidityPeriod)
        }
    }
}