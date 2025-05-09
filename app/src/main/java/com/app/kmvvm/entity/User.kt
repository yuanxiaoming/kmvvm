package com.app.kmvvm.entity

import com.framework.annotation.Prefs
import com.framework.annotation.PrefsField
import kotlinx.serialization.Serializable

@Prefs
@Serializable
data class User(
    @PrefsField
    val username: String,
    @PrefsField
    val isMan: Boolean = false,

    @PrefsField
    val number: Float = 0.1f,

    @PrefsField
    val age: Int = 27,

    @PrefsField
    val money: Double = 12.0,
    @PrefsField
    val time: Long = 1L,
    val nu: MutableList<String> = mutableListOf()
)