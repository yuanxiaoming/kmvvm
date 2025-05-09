package com.framework.annotation


/**
 * 状态栏
 * @date 2019/8/19 00:19
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class StatusBar(
    /**
     * 隐藏状态栏
     */
    val hide: Boolean = false,
    /**
     * 状态栏注解是否可用<br/>
     * true:可用<br/>
     * false:不可用<br/>
     */
    val enabled: Boolean = true,
    /**
     * 状态栏透明
     */
    val transparent: Boolean = false
)