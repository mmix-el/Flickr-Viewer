package xyz.mmixel.flickrviewer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PhotosViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getPhotos()
    }

    private fun getPhotos() {
        _status.value = "OK"
    }
}