package xyz.mmixel.flickrviewer.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import xyz.mmixel.flickrviewer.BuildConfig
import xyz.mmixel.flickrviewer.model.ResponseEntity

private const val BASE_URL = "https://api.flickr.com/services/rest/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface FlickrApiService {
    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&text=dogs" +
            "&api_key=${BuildConfig.FLICKR_API_KEY}&secret=${BuildConfig.FLICKR_SECRET}")
    suspend fun getPhotos(): ResponseEntity
}

object FlickrApi {
    val retrofitService: FlickrApiService by lazy {
        retrofit.create(FlickrApiService::class.java)
    }
}


