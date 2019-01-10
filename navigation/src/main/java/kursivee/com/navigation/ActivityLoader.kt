package kursivee.com.navigation

import android.content.Intent

object ActivityLoader {
    private val PACKAGE_NAME = "kursivee.com.core"

    fun getIntent(className: String): Intent? {
        try {
            Class.forName(className).run {
                return Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, className)
            }
        } catch (e: Throwable) {
            return null
        }
    }

}