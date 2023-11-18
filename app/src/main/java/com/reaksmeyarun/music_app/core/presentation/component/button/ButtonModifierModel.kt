package com.reaksmeyarun.music_app.core.presentation.component.button

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.ui.theme.ButtonTextColor

open class ButtonModifier {

    var buttonColors: Color? = null
        private set
    var radius: Dp = 12.dp
        private set
    var contentPaddingVertical: Dp = 8.dp
        private set
    var contentPaddingHorizontal: Dp = 16.dp
        private set
    var padding: Dp = 0.dp
        private set
    var textColor: Color = ButtonTextColor
        private set

    fun buttonColors(buttonColors: Color) = this.apply {
        this.buttonColors = buttonColors
    }

    fun radius(radius: Dp) = this.apply {
        this.radius = radius
    }

    fun contentPaddingVertical(contentPaddingVertical: Dp) = this.apply {
        this.contentPaddingVertical = contentPaddingVertical
    }

    fun contentPaddingHorizontal(contentPaddingHorizontal: Dp) = this.apply {
        this.contentPaddingHorizontal = contentPaddingHorizontal
    }

    fun padding(padding: Dp) = this.apply {
        this.padding = padding
    }

    fun textColor(textColor: Color) = this.apply {
        this.textColor = textColor
    }

}