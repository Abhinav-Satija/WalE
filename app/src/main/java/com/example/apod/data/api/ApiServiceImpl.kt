package com.mindorks.framework.mvvm.data.api

import com.example.apod.data.api.ApiService
import com.mindorks.framework.mvvm.data.model.Adop
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService {

    override fun getadopData(): Single<Adop> {
        return Rx2AndroidNetworking.get("https://api.nasa.gov/planetary/apod?api_key=UL8yChGZkeKH2gidskaVhpaAD6sdD1kfqBR7eASS")
            .build()
            .getObjectSingle(Adop::class.java)
    }

}