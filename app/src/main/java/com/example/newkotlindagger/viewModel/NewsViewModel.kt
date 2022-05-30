package com.example.newkotlindagger.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newkotlindagger.pojo.NewsModel
import com.example.newkotlindagger.repositry.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class NewsViewModel
@Inject

constructor(private val repository: Repository) : ViewModel() {
    private val mutableLiveData = MutableLiveData<List<NewsModel>>()
    val apiLiveData: LiveData<List<NewsModel>>
        get() = mutableLiveData

    fun getNews() = viewModelScope.launch {
        val result = repository.getData()
        if (result.isSuccessful) {
            if (result.body() != null) {
                mutableLiveData.postValue(result.body())
            } else {
                Log.i("error", result.message())
            }
        }

    }
}