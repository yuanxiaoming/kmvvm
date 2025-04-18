package com.app.kmvvm.transparent

import com.app.kmvvm.databinding.ActivityTransparentBinding
import com.bumptech.glide.Glide
import com.framework.annotation.StatusBar
import com.framework.mvvm.base.activity.BaseVMActivity

@StatusBar(transparent = true)
class TransparentActivity : BaseVMActivity<ActivityTransparentBinding, TransparentViewModel>() {
    override fun initParam() {

    }

    override fun initView() {

    }

    override fun initFlow() {
        viewModel.liveData.observe(this) {
            Glide.with(this@TransparentActivity).load(it.imagePath).into(bodyBinding.banner)
            snackBar(it.title)
        }
    }
}
