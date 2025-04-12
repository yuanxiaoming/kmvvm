package com.framework.mvvm.base.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.framework.mvvm.base.view.BaseVMView
import com.framework.mvvm.base.viewmodel.BaseViewModel
import com.framework.mvvm.ksp.KotlinMvvmCompiler
import java.lang.reflect.ParameterizedType

/**
 * @date 2019/4/6 11:07
 */
abstract class BaseVMActivity<VB : ViewBinding, VM : BaseViewModel> : BaseActivity<VB>(),
    BaseVMView {
    companion object {
        private const val TAG = "BaseVMActivity"
    }

    private val fullTag by lazy {
        "${javaClass.simpleName}_${TAG}"
    }

    val viewModel: VM by lazy {
        val type = javaClass.genericSuperclass
        val modelClass: Class<VM> = (type as ParameterizedType).actualTypeArguments[1] as Class<VM>
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[modelClass]
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParam()
        lifecycle.addObserver(viewModel)
        initLoadingObserver()
        initView()
        initFlow()
    }

    private fun initLoadingObserver() {
        viewModel.loadingDialogLiveData.observe(this) {
            if (it) {
                loadingDialog()
            }
        }
        viewModel.loadingViewLiveData.observe(this) {
            if (it) {
                loadingView()
            }
        }
        viewModel.hideLoadingLiveData.observe(this) {
            if (it) {
                hideLoading()
            }
        }
        viewModel.errorLiveData.observe(this) {
            if (it != null) {
                KotlinMvvmCompiler.onError(this, it)
            }
        }
        viewModel.showFailedViewLiveData.observe(this) {
            if (it) {
                showFailedView()
            } else {
                removeFailedView()
            }
        }
    }
}
