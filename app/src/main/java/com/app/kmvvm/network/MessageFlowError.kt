package com.app.kmvvm.network

import com.framework.mvvm.base.activity.BaseActivity
import com.framework.mvvm.base.fragment.BaseFragment
import com.framework.mvvm.base.view.BaseView
import com.framework.mvvm.interfaces.IFlowError

@com.framework.annotation.FlowError
class MessageFlowError : IFlowError {
    override fun onBaseFragmentError(baseFragment: BaseFragment<*>, t: Throwable) {

    }

    override fun onBaseActivityError(baseActivity: BaseActivity<*>, t: Throwable) {

    }

    override fun onError(any: Any, t: Throwable) {
        t.printStackTrace()
        t.message?.let {
            when (any) {
                is BaseView -> {
                    any.snackBar(it)
                }
                else -> {
                }
            }
        }
    }
}