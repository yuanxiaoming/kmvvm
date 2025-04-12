package com.app.kmvvm.network.api

import com.app.kmvvm.entity.Article
import com.app.kmvvm.entity.Banner
import com.app.kmvvm.entity.PageData
import com.app.kmvvm.entity.User
import com.app.kmvvm.network.ResponseBodyConverter
import com.app.kmvvm.network.interceptor.RequestInterceptor
import com.framework.annotation.ServiceApi
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import retrofit2.http.*


@ServiceApi(
        baseUrl = "https://www.wanandroid.com/",
        responseConverter = ResponseBodyConverter::class,
        interceptors = [RequestInterceptor::class],
        debugInterceptors = [OkHttpProfilerInterceptor::class]
)
interface WanAndroidService {

    @POST("user/register")
    suspend fun register(@Body map: Map<String, String>): String

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
            @Field("username") username: String,
            @Field("password") password: String
    ): User

    @GET("banner/json")
    suspend fun queryBanner(): MutableList<Banner>

    @GET("article/list/{pageIndex}/json")
    suspend fun queryArticles(
            @Path("pageIndex") pageIndex: Int,
            @Query("page_size") pageSize: Int
    ): PageData<Article>
}