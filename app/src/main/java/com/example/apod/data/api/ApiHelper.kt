package com.example.apod.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getadopData() = apiService.getadopData()

}