package com.example.livreinformatique.animation

import android.view.View
import androidx.viewpager.widget.ViewPager

class MyPageTransformer : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val scaleFactor = 0.85f
        val minScale = 0.5f

        if (position < -1) {
            page.alpha = 0f
        } else if (position <= 0) {
            page.alpha = 1f
            page.scaleX = Math.max(minScale, 1 - Math.abs(position) * (1 - scaleFactor))
            page.scaleY = Math.max(minScale, 1 - Math.abs(position) * (1 - scaleFactor))
        } else if (position <= 1) {
            page.alpha = 1f
            page.scaleX = Math.max(minScale, scaleFactor * (1 - Math.abs(position)) + minScale * Math.abs(position))
            page.scaleY = Math.max(minScale, scaleFactor * (1 - Math.abs(position)) + minScale * Math.abs(position))
        } else {
            page.alpha = 0f
        }
    }
}
