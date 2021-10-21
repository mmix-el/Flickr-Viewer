package xyz.mmixel.flickrviewer.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.mmixel.flickrviewer.databinding.GridViewItemBinding
import xyz.mmixel.flickrviewer.model.Photo


/**
 * Adapter for the [RecyclerView]. Displays [List] data objects using list diffs calculation.
 */
class PhotosAdapter : ListAdapter<Photo,
        PhotosAdapter.PhotoViewHolder>(DiffCallback) {

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Replaces the contents of a view
     */
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }

    /**
     * The PhotosViewHolder takes the [GridViewItemBinding] from the associated
     * grid_view_item and provide access to all the views for a data item in a holder.
     */
    class PhotoViewHolder(
        private var binding:
        GridViewItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Photo: Photo) {
            binding.photo = Photo
            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [Photo] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.url == newItem.url
        }
    }

}