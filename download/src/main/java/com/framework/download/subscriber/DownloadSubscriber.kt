package com.framework.download.subscriber

import android.os.Handler
import android.os.Looper
import com.framework.download.entity.DownloadProgress
import com.framework.utils.ext.logd
import com.framework.utils.ext.loge
import com.framework.download.callback.DownloadCallback
import com.framework.download.callback.DownloadProgressListener
import io.reactivex.rxjava3.subscribers.ResourceSubscriber

/**
 * 下载观察者
 * @date 2020/11/20 10:25
 */
internal class DownloadSubscriber(private val downloadCallback: DownloadCallback) :
    ResourceSubscriber<String>(), DownloadProgressListener {
    companion object {
        const val TAG = "DownloadSubscriber"
    }

    private val handler = Handler(Looper.getMainLooper())

    public override fun onStart() {
        super.onStart()
        "onStart".logd(TAG)
        downloadCallback.onStart()
    }

    override fun onNext(t: String) {
        "onNext($t)".logd(TAG)
        downloadCallback.onSuccess(t)
    }

    override fun onError(t: Throwable?) {
        t?.let {
            if (t is Exception) {
                t.printStackTrace()
            }
            "onError(${it})".loge(TAG)
            downloadCallback.onError(it)
        }
    }

    override fun onComplete() {
        "onComplete".logd(TAG)
        downloadCallback.onComplete()
    }

    override fun update(read: Long, count: Long, done: Boolean) {
        handler.post {
            val downloadProgress = if (done) {
                DownloadProgress(read, count, 1, 1)
            } else {
                DownloadProgress(read, count, 0, 1)
            }
            "update($read,$count,$done)".logd(TAG)
            downloadCallback.onProgress(downloadProgress)
        }
    }
}