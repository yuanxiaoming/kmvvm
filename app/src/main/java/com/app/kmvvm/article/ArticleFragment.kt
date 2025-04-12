package com.app.kmvvm.article

import androidx.recyclerview.widget.LinearLayoutManager
import com.app.kmvvm.R
import com.app.kmvvm.adapter.ArticleAdapter
import com.app.kmvvm.databinding.FragmentArticleBinding
import com.framework.mvvm.base.fragment.BaseVMFragment
import com.gyf.immersionbar.ktx.statusBarHeight
import com.framework.mvvm.ext.lifecycleRefresh

class ArticleFragment : BaseVMFragment<FragmentArticleBinding, ArticleViewModel>() {
    companion object {
        fun newInstance(): ArticleFragment {
            return ArticleFragment()
        }
    }

    private lateinit var articleAdapter: ArticleAdapter;

    override fun initParam() {
    }

    override fun initView() {
        rootBinding {
            topView.setBackgroundResource(R.color.colorPrimary);
            topView.post {
                topView.layoutParams.height = statusBarHeight
            }
        }
        articleAdapter = ArticleAdapter()
        bodyBinding {
            refreshView.apply {
                val linearLayoutManager = LinearLayoutManager(context)
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                setLayoutManager(linearLayoutManager)
                setAdapter(articleAdapter)
                autoRefresh()
            }
        }
        bodyBinding.refreshView.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            setLayoutManager(linearLayoutManager)
            setAdapter(articleAdapter)
            autoRefresh()
        }
    }

    override fun initFlow() {
        bodyBinding.refreshView.run {
            setOnRefreshLoadMoreListener { nextPageIndex ->
                viewModel.queryArticles(nextPageIndex)
                    .lifecycleRefresh(this@ArticleFragment, this)
            }
        }
    }
}