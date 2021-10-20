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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhotosBinding.inflate(inflater)
        binding.viewModel = viewModel
        return  binding.root
    }
}