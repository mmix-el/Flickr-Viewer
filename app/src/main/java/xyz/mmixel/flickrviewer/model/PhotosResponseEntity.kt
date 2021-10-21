package xyz.mmixel.flickrviewer.model

/**
 * Support classes to help Moshi generate Kotlin objects from JSON
 */

data class ResponseEntity(
    val photos: ResponseMetadata,
    val stat: String
)

data class ResponseMetadata(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: List<PhotoEntity>
)


data class PhotoEntity(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int
)