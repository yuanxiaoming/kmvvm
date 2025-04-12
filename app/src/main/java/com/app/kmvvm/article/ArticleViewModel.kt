package com.app.kmvvm.article

import com.app.kmvvm.entity.Article
import com.app.kmvvm.repository.WanAndroidRepository
import com.framework.mvvm.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.Flow

class ArticleViewModel : BaseViewModel() {
    fun queryArticles(pageIndex: Int): Flow<MutableList<Article>> {
        return WanAndroidRepository.queryArticles(pageIndex)
    }
}