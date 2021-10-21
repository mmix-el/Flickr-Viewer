package xyz.mmixel.flickrviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import xyz.mmixel.flickrviewer.databinding.FragmentPhotosBinding

class PhotosFragment : Fragment() {
    private val viewModel: PhotosViewModel by viewModels()
    private lateinit var binding: FragmentPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflating the layout with the Data Binding
        binding = FragmentPhotosBinding.inflate(inflater)
        // Setting the lifecycle owner on the fragment
        binding.lifecycleOwner = this
        // Getting access to the viewModel for the Binding
        binding.viewModel = viewModel
        // Setting the RecyclerView with an adapter
        binding.recyclerview.adapter = PhotosAdapter()
        return binding.root
    }
}