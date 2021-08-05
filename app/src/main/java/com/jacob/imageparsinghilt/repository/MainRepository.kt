package com.jacob.imageparsinghilt.repository

import com.jacob.imageparsinghilt.api.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: ApiService) {
    suspend fun getData() = api.getPhotos()
}