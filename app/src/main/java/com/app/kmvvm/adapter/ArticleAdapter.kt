package com.app.kmvvm.adapter

import com.app.kmvvm.databinding.ItemArticleBinding
import com.app.kmvvm.entity.Article
import com.framework.mvvm.base.adapter.CommonViewHolder
import com.framework.mvvm.base.adapter.RecyclerAdapter

class ArticleAdapter : RecyclerAdapter<Article, ItemArticleBinding>() {

    override fun bindViewHolder(
        holder: CommonViewHolder<ItemArticleBinding>,
        m: Article,
        position: Int
    ) {
        holder.viewBanding {
            title.text = m.title
        }
    }
}