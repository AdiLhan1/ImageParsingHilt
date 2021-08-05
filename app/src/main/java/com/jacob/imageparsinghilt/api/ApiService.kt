package com.jacob.imageparsinghilt.api

import com.jacob.imageparsinghilt.models.PhotoModel
import com.jacob.imageparsinghilt.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getPhotos(): Response<List<PhotoModel>>
}