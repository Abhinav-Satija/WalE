package com.example.apod.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mindorks.framework.mvvm.data.model.Adop
import com.example.apod.data.repository.MainRepository
import com.example.apod.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

     val adopData = MutableLiveData<Resource<Adop>>()
    private val compositeDisposable = CompositeDisposable()

init {
    fetchadopData()
}


     fun fetchadopData() {
         adopData.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getadopData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    adopData.postValue(Resource.success(userList))
                }, { throwable ->
                    adopData.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}