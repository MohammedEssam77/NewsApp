package com.example.newkotlindagger.repositry

import com.example.newkotlindagger.apiService.ApiService
import javax.inject.Inject

class Repository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getData() = apiService.getData()

}
