package com.app.kmvvm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.kmvvm.article.ArticleFragment
import com.app.kmvvm.index.IndexFragment

class MainAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> IndexFragment.newInstance()
            1 -> ArticleFragment.newInstance()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}