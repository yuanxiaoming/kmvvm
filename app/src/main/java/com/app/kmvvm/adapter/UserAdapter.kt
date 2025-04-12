package com.app.kmvvm.adapter

import com.app.kmvvm.databinding.ItemUserBinding
import com.app.kmvvm.entity.User
import com.framework.mvvm.base.adapter.CommonViewHolder
import com.framework.mvvm.base.adapter.RecyclerAdapter

/**
 *
 * @author TLi2
 **/
class UserAdapter : RecyclerAdapter<User, ItemUserBinding>() {
    init {
//        setShowEmptyEnabled(false)
    }
    override fun bindViewHolder(holder: CommonViewHolder<ItemUserBinding>, m: User, position: Int) {
        holder.viewBanding {
            name.text = m.username
        }
    }
}