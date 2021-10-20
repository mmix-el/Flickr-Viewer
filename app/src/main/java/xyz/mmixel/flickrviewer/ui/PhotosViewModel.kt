package xyz.mmixel.flickrviewer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.mmixel.flickrviewer.network.FlickrApi

class PhotosViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            try {
                val listResult = FlickrApi.retrofitService.getPhotos()
                _status.value = "Success: ${listResult.photos.photo.joinToString(" ")}"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}