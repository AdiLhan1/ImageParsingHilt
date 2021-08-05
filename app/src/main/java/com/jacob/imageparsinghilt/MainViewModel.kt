package com.jacob.imageparsinghilt

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jacob.imageparsinghilt.models.PhotoModel
import com.jacob.imageparsinghilt.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val repository: MainRepository) : ViewModel() {
    val data: MutableLiveData<List<PhotoModel>> = MutableLiveData()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            repository.getData().let {
                if (it.isSuccessful) {
                    data.value = it.body()
                } else {
                    Log.e("TAG", "getData: ERROR!")
                }
            }
        }
    }
}