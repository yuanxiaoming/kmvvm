package com.app.kmvvm.apk.view

import android.Manifest
import com.app.kmvvm.R
import com.app.kmvvm.apk.viewmodel.InstallApkViewModel
import com.app.kmvvm.databinding.ActivityInstallApkBinding
import com.framework.annotation.Title
import com.framework.mvvm.base.activity.BaseVMActivity
import com.framework.utils.ext.installApk
import com.framework.utils.ext.logd
import com.tbruyelle.rxpermissions3.RxPermissions

/**
 * @date 2020/11/20 15:50
 */
@Title(R.string.download_install_apk)
class InstallApkActivity : BaseVMActivity<ActivityInstallApkBinding, InstallApkViewModel>() {
    private val rxPermissions by lazy { RxPermissions(this) }

    companion object {
        private const val TAG = "InstallApkActivity"
    }

    override fun initParam() {

    }

    override fun initView() {
        rxPermissions
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe {
                if (it) {
                    viewModel.download()
                }
            }
    }

    override fun initFlow() {
        viewModel.progressLiveData.observe(this) {
            bodyBinding.progressBar.progress = (it.readLength * 100 / it.countLength).toInt()
        }
        viewModel.progressLiveData1.observe(this) {
            "${(it.readLength * 100 / it.countLength).toInt()}".logd(TAG)
            bodyBinding.progressBar1.progress = (it.readLength * 100 / it.countLength).toInt()
            bodyBinding.progressText.text = "${it.completeCount}/${it.totalCount}"
        }
        viewModel.installApkLiveData.observe(this) {
            installApk(it)
        }
    }
}