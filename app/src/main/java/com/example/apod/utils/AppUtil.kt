package com.example.apod.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

class AppUtil {

    lateinit var toast: Toast

    //Function to check network, return value type is boolean
    fun haveNetworkConnection(context: Context): Boolean {
        var haveConnectedWifi = false
        var haveConnectedMobile = false
        val cm = context.getSystemService (Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.allNetworkInfo
        for (ni in netInfo) {
            if (ni.typeName.equals("WIFI", ignoreCase = true)) if (ni.isConnected) haveConnectedWifi = true
            if (ni.typeName.equals("MOBILE", ignoreCase = true)) if (ni.isConnected) haveConnectedMobile = true
        }
        return haveConnectedWifi || haveConnectedMobile
    }

    fun showToast(context: Context, message: String?) {
      toast=  Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast.show()

    }
}