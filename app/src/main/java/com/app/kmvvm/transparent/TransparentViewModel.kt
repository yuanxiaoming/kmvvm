package com.app.kmvvm.transparent

import androidx.lifecycle.MutableLiveData
import com.app.kmvvm.entity.Banner
import com.app.kmvvm.repository.WanAndroidRepository
import com.framework.mvvm.base.viewmodel.BaseViewModel
import com.framework.mvvm.ext.lifecycleLoadingView

class TransparentViewModel : BaseViewModel() {
    val liveData = MutableLiveData<Banner>()

    override fun onCreate() {
        banner()
    }

    fun banner() {
        WanAndroidRepository.queryBanner().lifecycleLoadingView(this) {
            liveData.value = this
        }
//        WanAndroidRepository.queryBanner().lifecycleLoadingDialog(this) {
//            liveData.value = this
//        }
//        WanAndroidRepository.queryBanner().lifecycle(this) {
//            liveData.value = this
//        }
    }
}