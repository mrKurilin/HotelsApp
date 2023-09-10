package ru.mrkurilin.hotelsApp.ui.imageSlider

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ru.mrkurilin.hotelsApp.ui.databinding.ImageSliderItemBinding

class ImageViewHolder(
    private val imageSliderItemBinding: ImageSliderItemBinding,
) : RecyclerView.ViewHolder(imageSliderItemBinding.root) {

    fun bind(url: String) {
        Glide.with(imageSliderItemBinding.root.context)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(imageSliderItemBinding.ivImages)
    }
}
