package com.example.apod.ui.main.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.apod.R
import com.example.apod.data.api.ApiHelper
import com.example.apod.ui.base.ViewModelFactory
import com.example.apod.ui.main.viewmodel.MainViewModel
import com.example.apod.utils.AppDatabase
import com.example.apod.utils.AppUtil
import com.example.apod.utils.Status
import com.mindorks.framework.mvvm.data.api.ApiServiceImpl
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupObserver()

    }


    private fun setupObserver() {
        mainViewModel.adopData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    var appDatabase: AppDatabase = AppDatabase.getAppDataBase(this)!!

                    it.data?.let { println("$it") }

                    it.data?.let { it1 -> appDatabase.apodDao().insertApodData(it1) }
                    println(appDatabase.apodDao().getApod().hdurl)
                    setupUI()


                }
                Status.LOADING -> {


                }
                Status.ERROR -> {
                    //Handle Error
                    AppUtil().showToast(this, it.message)

                }
            }
        })
    }


    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        //setting up all the ui components
        val appDatabase: AppDatabase = AppDatabase.getAppDataBase(this)!!
        //checking data is availabe or not
        if (null == appDatabase.apodDao().getApod()) {
            AppUtil().showToast(this, "Data Not Available")

        } else {
            Glide.with(this).load(appDatabase.apodDao().getApod().hdurl).into(imageViewAdop);
            textViewTitle.text = appDatabase.apodDao().getApod().title
            textViewDescription.text = appDatabase.apodDao().getApod().explanation
            textViewDescription.movementMethod = ScrollingMovementMethod()
        }


    }

}
