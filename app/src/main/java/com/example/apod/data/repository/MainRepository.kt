package com.example.apod.data.repository

import com.example.apod.data.api.ApiHelper
import com.mindorks.framework.mvvm.data.model.Adop
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getadopData(): Single<Adop> {
        return apiHelper.getadopData()
    }

}