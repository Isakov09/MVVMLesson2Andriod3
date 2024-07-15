package com.example.mvvmlesson2andriod3.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlesson2andriod3.models.Photo
import com.example.mvvmlesson2andriod3.models.PhotosResponse
import com.example.mvvmlesson2andriod3.utils.parseJsonToModel
import com.example.mvvmlesson2andriod3.utils.readJsonFromAssets


class HomeViewModel(private val application: Application) : AndroidViewModel(application) {

    private val _photo = MutableLiveData<Photo>()
    val photo: LiveData<Photo> get() = _photo

    fun getPhotos(): PhotosResponse {
        val photosJsonString = application.applicationContext.readJsonFromAssets("photos.json")
        val response = parseJsonToModel<PhotosResponse>(photosJsonString)
        return response
    }
    fun setPhoto(photo: Photo) {
        _photo.value = photo
    }

    //это он крей начала создание
    override fun onCleared() {
        super.onCleared()
    }
}