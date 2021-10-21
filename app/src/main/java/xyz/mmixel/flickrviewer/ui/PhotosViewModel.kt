package xyz.mmixel.flickrviewer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.mmixel.flickrviewer.model.Photo
import xyz.mmixel.flickrviewer.model.PhotoEntity
import xyz.mmixel.flickrviewer.network.FlickrApi

enum class ApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] of the [PhotosFragment].
 */
class PhotosViewModel : ViewModel() {
    // Status of the last request
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    // List of photos
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    init {
        getPhotos()
    }

    /**
     * Gets photos from the Flicker API service and updates the
     * [List] of [Photo] wrapped in [LiveData].
     */
    private fun getPhotos() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _photos.value =
                    FlickrApi.retrofitService.getPhotos().photos.photo.map { photoEntity ->
                        Photo(
                            id = photoEntity.id,
                            title = photoEntity.title,
                            url = makeUrlFromPE(photoEntity)
                        )
                    }
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }

    /**
     * Forms a correct [Photo] URL
     */
    private fun makeUrlFromPE(pe: PhotoEntity) =
        "https://farm${pe.farm}.staticflickr.com/${pe.server}/${pe.id}_${pe.secret}.jpg"

}