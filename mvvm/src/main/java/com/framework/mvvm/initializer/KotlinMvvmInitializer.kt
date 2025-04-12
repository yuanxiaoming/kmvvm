package com.framework.mvvm.initializer

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.framework.mvvm.lifecycle.ActivityLifeCycleCallbacksImpl
import com.framework.utils.LogUtils
import com.framework.utils.ext.logd
import com.framework.utils.manager.ContextManager

class KotlinMvvmInitializer : Initializer<Boolean> {
    companion object {
        private const val TAG = "KotlinMvvmInitializer"
    }

    override fun create(context: Context): Boolean {
        val applicationContext = context.applicationContext
        initLog()
        initContext(applicationContext)
        "create".logd(TAG)
        return true
    }

    private fun initContext(applicationContext: Context) {
        ContextManager.getInstance().init(applicationContext)
        val application = applicationContext as Application
        application.registerActivityLifecycleCallbacks(ActivityLifeCycleCallbacksImpl())
    }

    private fun initLog() {
        LogUtils.init()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}