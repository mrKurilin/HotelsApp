package ru.mrkurilin.bookingFeature.presentation.payment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.mrkurilin.hotelsApp.bookingFeature.R
import ru.mrkurilin.navigation.navigate

class PaymentFragment : Fragment(R.layout.fragment_payment) {

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.payment_success)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().findViewById<Button>(R.id.super_button).setOnClickListener {
            navigate(R.id.action_paymentFragment_to_hotelsFragment)
        }
    }
}