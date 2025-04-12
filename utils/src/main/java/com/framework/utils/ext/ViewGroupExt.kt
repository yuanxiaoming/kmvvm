package com.framework.utils.ext

import android.view.LayoutInflater
import android.view.ViewGroup


fun ViewGroup.layoutInflater(): LayoutInflater {
    return LayoutInflater.from(context)
}