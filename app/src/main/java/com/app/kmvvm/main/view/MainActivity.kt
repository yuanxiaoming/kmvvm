package com.app.kmvvm.main.view

import androidx.viewpager2.widget.ViewPager2
import com.app.kmvvm.adapter.MainAdapter
import com.app.kmvvm.databinding.ActivityMainBinding
import com.app.kmvvm.main.viewmodel.MainViewModel
import com.framework.annotation.StatusBar
import com.framework.mvvm.base.activity.BaseVMActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.gyf.immersionbar.ktx.immersionBar

@StatusBar(transparent = true)
class MainActivity : BaseVMActivity<ActivityMainBinding, MainViewModel>() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var mainAdapter: MainAdapter
    override fun initParam() {
        immersionBar {
            statusBarDarkFont(true, 0.5f)
        }
    }

    override fun initView() {
        mainAdapter = MainAdapter(this)
        bodyBinding.run {
            viewPager.adapter = mainAdapter
            viewPager.currentItem = 0
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> {
                            immersionBar {
                                statusBarDarkFont(true, 0.5f)
                            }
                        }

                        1 -> {
                            immersionBar {
                                statusBarDarkFont(true, 0.2f)
                            }
                        }

                        else -> {
                        }
                    }
                }
            })
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "首页"
                    1 -> tab.text = "文章"
                }
            }.attach()
        }
    }

    override fun initFlow() {

    }


}
