package com.app.kmvvm.network

import com.framework.annotation.FlowError
import com.framework.mvvm.base.activity.BaseActivity
import com.framework.mvvm.base.fragment.BaseFragment
import com.framework.mvvm.interfaces.IFlowError

@FlowError
class TokenFlowError : IFlowError {
    override fun onBaseFragmentError(baseFragment: BaseFragment<*>, t: Throwable) {

    }

    override fun onBaseActivityError(baseActivity: BaseActivity<*>, t: Throwable) {

    }

    override fun onError(any: Any, t: Throwable) {
        t.printStackTrace()
    }
}