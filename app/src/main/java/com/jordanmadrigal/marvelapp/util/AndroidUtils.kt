package com.jordanmadrigal.marvelapp.util

import android.app.Activity
import com.google.android.material.snackbar.Snackbar
import com.jordanmadrigal.marvelapp.R

class AndroidUtils {
    companion object{
        fun showSnackBar(activity: Activity, msg: String) {

            Snackbar.make(activity.findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG)
                .setAction("Dismiss") {
                }.setActionTextColor(activity.resources.getColor(R.color.marvel_red, null))
                .show()
        }
    }
}