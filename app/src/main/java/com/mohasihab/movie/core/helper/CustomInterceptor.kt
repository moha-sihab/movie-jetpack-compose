package com.mohasihab.movie.core.helper

import com.mohasihab.moviejetpackcompose.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("api_key", BuildConfig.API_KEY).build()
        )
    }
}
