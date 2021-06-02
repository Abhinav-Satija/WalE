package com.example.apod.data.api

import com.mindorks.framework.mvvm.data.model.Adop
import io.reactivex.Single

interface ApiService {

    fun getadopData(): Single<Adop>

}