package com.app.kmvvm.fullscreen

import android.os.Bundle
import com.app.kmvvm.databinding.ActivityFullScreenBinding
import com.framework.annotation.StatusBar
import com.framework.mvvm.base.activity.BaseActivity

@StatusBar(hide = true)
class FullScreenActivity : BaseActivity<ActivityFullScreenBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bodyBinding.root.setOnClickListener {
            loadingDialog()
            it.postDelayed({
                hideLoading()
            }, 5000)
        }
    }
}
