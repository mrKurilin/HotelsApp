package ru.mrkurilin.hotelFeature.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import ru.mrkurilin.hotelsApp.hotelFeature.R

class AboutHotelButton(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.about_hotel_button_view, this)

        val attrsTypedArray = context.obtainStyledAttributes(attrs, R.styleable.AboutHotelButton)
        try {
            val drawableId = attrsTypedArray.getResourceId(R.styleable.AboutHotelButton_icon, 0)

            if (drawableId != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableId)
                findViewById<ImageView>(R.id.icon_image_view).setImageDrawable(drawable)
            }

            findViewById<TextView>(
                R.id.title_text_view
            ).text = attrsTypedArray.getString(R.styleable.AboutHotelButton_title)
            findViewById<TextView>(
                R.id.description_text_view
            ).text = attrsTypedArray.getString(R.styleable.AboutHotelButton_description)
        } finally {
            attrsTypedArray.recycle()
        }
    }
}