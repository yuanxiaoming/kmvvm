package com.app.kmvvm.config

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.framework.annotation.TextStyle
import com.app.kmvvm.R
import com.app.kmvvm.databinding.LayoutActivityErrorBinding
import com.app.kmvvm.databinding.LayoutEmptyBinding
import com.app.kmvvm.databinding.LayoutFragmentErrorBinding
import com.framework.mvvm.base.activity.BaseActivity
import com.framework.mvvm.base.fragment.BaseFragment
import com.framework.mvvm.interfaces.IGlobalConfig
import com.framework.utils.ext.layoutInflater

@com.framework.annotation.GlobalConfig
class MvvmGlobalConfig : IGlobalConfig {
    override fun getTitleHeight(): Int {
        return R.dimen.title_bar_height
    }

    override fun getTitleBackIcon(): Int {
        return R.drawable.back_black
    }

    override fun getTitleBackground(): Int {
        return R.color.colorPrimary
    }

    override fun getTitleTextColor(): Int {
        return R.color.white
    }

    override fun getTitleTextStyle(): Int {
        return TextStyle.BOLD
    }

    override fun isShowTitleLine(): Boolean {
        return true
    }

    override fun getTitleLineColor(): Int {
        return R.color.color_black
    }

    override fun getLoadingColor(): Int {
        return R.color.color_black
    }

    override fun getLoadingBackground(): Int {
        return R.color.white
    }

    override fun getRecyclerEmptyBinding(parent: ViewGroup): ViewBinding {
        return LayoutEmptyBinding.inflate(parent.layoutInflater(), parent, false)
    }

    override fun getFailedBinding(layoutInflater: LayoutInflater, any: Any): ViewBinding? {
        return when (any) {
            is BaseActivity<*> -> {
                LayoutActivityErrorBinding.inflate(layoutInflater)
            }

            is BaseFragment<*> -> {
                LayoutFragmentErrorBinding.inflate(layoutInflater)
            }

            else -> {
                null
            }
        }
    }

    override fun onFailedReloadClickId(): Int {
        return R.id.failed_reload
    }

    override fun getPageSize(): Int {
        return 16
    }

    override fun getStartPageIndex(): Int {
        return 0
    }
}