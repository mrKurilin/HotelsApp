package ru.mrkurilin.hotelsApp.ui.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import ru.mrkurilin.hotelsApp.ui.R

class RatingView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val ratingText: TextView

    init {
        inflate(context, R.layout.rating_view, this)
        ratingText = findViewById(R.id.rating_text_view)
    }

    fun setRating(rating: Int, ratingName: String) {
        ratingText.text = context.getString(R.string.rating_text, rating, ratingName)
    }
}