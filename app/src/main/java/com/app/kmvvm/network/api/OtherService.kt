package com.app.kmvvm.network.api

import com.framework.annotation.ServiceApi
import com.app.kmvvm.network.Result
import com.framework.mvvm.network.converter.SerializationResponseBodyConverter
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import retrofit2.http.GET


@ServiceApi(
    baseUrl = "https://www.wanandroid.com/",
    responseConverter = SerializationResponseBodyConverter::class,
    debugInterceptors = [OkHttpProfilerInterceptor::class]
)
interface OtherService {
    @GET("banner/json")
    suspend fun queryBanner(): Result
}