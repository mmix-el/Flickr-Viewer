package xyz.mmixel.flickrviewer.ui

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import xyz.mmixel.flickrviewer.R
import xyz.mmixel.flickrviewer.model.Photo

object BindingAdapters {
    /**
     * Custom setter for [ImageView] to upload an image by URL using the Coil
     */
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            imgView.load(imgUri) {
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }
        }
    }

    /**
     * Custom setter for update [RecyclerView] data when the observed list changes
     */
    @BindingAdapter("listData")
    @JvmStatic
    fun bindRecyclerView(
        recyclerView: RecyclerView,
        data: List<Photo>?
    ) {
        val adapter = recyclerView.adapter as PhotosAdapter
        adapter.submitList(data)
    }

    /**
     * Custom setter for [ImageView] to handle api state changing
     */
    @BindingAdapter("apiStatus")
    @JvmStatic
    fun bindStatus(
        statusImageView: ImageView,
        status: ApiStatus?
    ) {
        when (status) {
            ApiStatus.LOADING -> {
                statusImageView.visibility = View.VISIBLE
                statusImageView.setImageResource(R.drawable.loading_animation)
            }
            ApiStatus.ERROR -> {
                statusImageView.visibility = View.VISIBLE
                statusImageView.setImageResource(R.drawable.ic_connection_error)
            }
            ApiStatus.DONE -> {
                statusImageView.visibility = View.GONE
            }
        }
    }


}