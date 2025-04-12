package com.app.kmvvm.repository

import com.app.kmvvm.entity.Article
import com.app.kmvvm.entity.Banner
import com.app.kmvvm.network.api.OtherService
import com.app.kmvvm.network.api.WanAndroidService
import com.framework.mvvm.ksp.KotlinMvvmCompiler
import com.framework.mvvm.network.manager.NetManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

object WanAndroidRepository {
    private val wanAndroidService =
        NetManager.getInstance().getService(WanAndroidService::class.java)

    //    private val otherService = NetManager.getInstance().getService(OtherService::class.java)
    fun getBanners(): Flow<MutableList<Banner>> {
        return flow {
            emit(wanAndroidService.queryBanner())
        }
    }

    fun queryBanner(): Flow<Banner> {
        return getBanners().map {
            return@map it[0]
        }
    }

    fun queryArticles(pageIndex: Int): Flow<MutableList<Article>> {
        val pageSize = KotlinMvvmCompiler.globalConfig().getPageSize() + 2
        return flow {
            emit(wanAndroidService.queryArticles(pageIndex, pageSize))
        }.map {
            return@map it.datas
        }
    }
}