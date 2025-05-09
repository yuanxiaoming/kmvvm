package com.app.kmvvm.index

import com.app.kmvvm.entity.Banner
import com.app.kmvvm.exception.HttpServerException
import com.app.kmvvm.repository.WanAndroidRepository
import com.framework.mvvm.base.viewmodel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class IndexViewModel : BaseViewModel() {
    companion object {
        private const val TAG = "IndexViewModel"
    }

//    private var failed = true
    fun queryBanners(): Flow<MutableList<Banner>> {
//        if (failed) {
//            failed = false
//            return flow {
//                delay(2000)
//                throw NullPointerException()
//            }
//        }
        return WanAndroidRepository.getBanners()
    }

    /**
     * 处理异常
     * @return Flow<Any>
     */
    fun handlerError(): Flow<Any> {
        return flowOf("").map {
            delay(2000)
            throw HttpServerException("001", "异常捕获")
        }
    }
}