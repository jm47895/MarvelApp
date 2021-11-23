package com.jordanmadrigal.marvelapp.util

import com.jordanmadrigal.marvelapp.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest

class Constants {
    companion object{
        const val BASE_URL = "https://gateway.marvel.com/"

        val timeStamp = System.currentTimeMillis().toString()
        const val API_KEY = BuildConfig.MARVEL_API_PUBLIC_KEY
        const val PRIVATE_KEY = BuildConfig.MARVEL_API_PRIVATE_KEY

        fun createHash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val messageDigest = MessageDigest.getInstance("MD5")
            return BigInteger(1, messageDigest.digest(input.toByteArray())).toString(16)
                .padStart(32, '0')
        }
    }
}