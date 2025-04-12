package com.app.kmvvm.index

import android.view.View
import com.bumptech.glide.Glide
import com.app.kmvvm.R
import com.app.kmvvm.apk.view.InstallApkActivity
import com.app.kmvvm.child.ChildActivity
import com.app.kmvvm.databinding.FragmentIndexBinding
import com.app.kmvvm.exception.HttpServerException
import com.app.kmvvm.fullscreen.FullScreenActivity
import com.app.kmvvm.recycle.RecycleActivity
import com.app.kmvvm.transparent.TransparentActivity
import com.framework.mvvm.base.fragment.BaseVMFragment
import com.framework.mvvm.ext.lifecycle
import com.framework.mvvm.ext.lifecycleLoadingDialog
import com.framework.utils.ext.startKtActivity

class IndexFragment : BaseVMFragment<FragmentIndexBinding, IndexViewModel>(),
    View.OnClickListener {
    companion object {
        fun newInstance(): IndexFragment {
            return IndexFragment()
        }
    }

    override fun initParam() {

    }

    override fun initView() {
        bodyBinding.run {
            banner.bindLifecycle(this@IndexFragment)
            banner.setAutoPlay(true)
            banner.setInfiniteLoop(true)
            banner.setImageLoader { imageView, path ->
                Glide.with(this@IndexFragment).load(path).into(imageView)
            }
            snackbar.setOnClickListener {
                snackBar("提示框")
            }
            openTitle.setOnClickListener(this@IndexFragment)
            transparent.setOnClickListener(this@IndexFragment)
            fullScreen.setOnClickListener(this@IndexFragment)
            recycle.setOnClickListener(this@IndexFragment)
            installApk.setOnClickListener(this@IndexFragment)
            handlerError.setOnClickListener(this@IndexFragment)
        }

    }

    override fun initFlow() {
//        onFailedReload {
        loadBanners()
//        }
    }

    private fun loadBanners() {
        viewModel.queryBanners().lifecycle(this, true) {
            val images = mutableListOf<String>()
            this.forEach {
                images.add(it.imagePath)
            }
            bodyBinding.banner.run {
                setImages(images)
                start()
            }
        }
    }

    fun add(a: Int, b: Int):Int = a+b

    override fun onClick(v: View) {
        when (v.id) {
            R.id.open_title -> {
                startKtActivity<ChildActivity>()
            }

            R.id.transparent -> {
                startKtActivity<TransparentActivity>()
            }

            R.id.full_screen -> {
                startKtActivity<FullScreenActivity>()
            }

            R.id.recycle -> {
                startKtActivity<RecycleActivity>()
            }

            R.id.installApk -> {
                startKtActivity<InstallApkActivity>()
            }

            R.id.handler_error -> {
                viewModel.handlerError().lifecycleLoadingDialog(this, errorCallback = {
                    if (it is HttpServerException) {
                        snackBar(it.message!!)
                    }
                }) {}
            }

            else -> {
            }
        }
    }

}