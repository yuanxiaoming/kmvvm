package com.framework.annotation

import androidx.annotation.IntDef
import com.framework.annotation.TextStyle.Companion.BOLD
import com.framework.annotation.TextStyle.Companion.BOLD_ITALIC
import com.framework.annotation.TextStyle.Companion.ITALIC
import com.framework.annotation.TextStyle.Companion.NORMAL

@IntDef(NORMAL, BOLD, ITALIC, BOLD_ITALIC)
annotation class TextStyle {
    companion object {
        /**
         * 正常
         */
        const val NORMAL: Int = 0

        /**
         * 粗体
         */
        const val BOLD: Int = 1

        /**
         * 斜体
         */
        const val ITALIC: Int = 2

        /**
         * 粗体+斜体
         */
        const val BOLD_ITALIC: Int = 3
    }
}
