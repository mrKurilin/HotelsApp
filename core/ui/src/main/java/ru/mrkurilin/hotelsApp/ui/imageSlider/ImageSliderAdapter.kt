package ru.mrkurilin.hotelsApp.ui.imageSlider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.hotelsApp.ui.databinding.ImageSliderItemBinding
import ru.mrkurilin.hotelsApp.ui.views.GenericDiffUtilCallback

class ImageSliderAdapter : RecyclerView.Adapter<ImageViewHolder>() {
    private var urls = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val imageSliderItemBinding = ImageSliderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageViewHolder(imageSliderItemBinding)
    }

    override fun getItemCount(): Int = urls.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(urls[position])
    }

    fun setItems(urls: List<String>) {
        val diffResult = DiffUtil.calculateDiff(
            GenericDiffUtilCallback(this.urls, urls)
        )
        this.urls = urls
        diffResult.dispatchUpdatesTo(this)
    }
}