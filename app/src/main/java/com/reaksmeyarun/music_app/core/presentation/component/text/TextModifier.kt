package com.reaksmeyarun.music_app.core.presentation.component.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.ui.theme.TextColor

open class TextModifier {

    var fontWeight: FontWeight = FontWeight.W300
        private set
    var textSize: TextUnit = 13.sp
        private set
    var maxLines: Int = Int.MAX_VALUE
        private set
    var minLines: Int = 1
        private set
    var textAlign: TextAlign = TextAlign.Start
        private set
    var isSelected: Boolean = true
        private set
    var color: Color = TextColor
        private set(value) {
            field = if (isSelected)
                value
            else
                value.copy(0.5f)
        }
    var style: TextStyle? = null
        private set

    fun color(color: Color) = this.apply {
        this.color = color
    }

    fun fontWeight(fontWeight: FontWeight) = this.apply {
        this.fontWeight = fontWeight
    }

    fun textSize(textSize: TextUnit) = this.apply {
        this.textSize = textSize
    }

    fun maxLines(maxLines: Int) = this.apply {
        this.maxLines = maxLines
    }

    fun minLines(minLines: Int) = this.apply {
        this.minLines = minLines
    }

    fun textAlign(textAlign: TextAlign) = this.apply {
        this.textAlign = textAlign
    }

    fun alignCenter() = this.apply {
        this.textAlign = TextAlign.Center
    }

    fun alignStart() = this.apply {
        this.textAlign = TextAlign.Start
    }

    fun alignEnd() = this.apply {
        this.textAlign = TextAlign.End
    }

    fun isSelected(isSelected: Boolean) = this.apply {
        this.isSelected = isSelected
    }

    fun style(style: TextStyle) = this.apply {
        this.style = style
    }

}

class SmallTextModifier : TextModifier() {
    init {
        textSize(12.sp)
    }

}

class ButtonTextModifier : TextModifier() {

    init {
        fontWeight(FontWeight.Bold)
        textSize(14.sp)
    }

}

class Body1TextModifier : TextModifier() {

    init {
        textSize(14.sp)
    }

}

class Header1TextModifier : TextModifier() {

    init {
        fontWeight(FontWeight.W500)
        textSize(14.sp)
    }

}

class Header2TextModifier : TextModifier() {

    init {
        fontWeight(FontWeight.W600)
        textSize(15.sp)
    }

}

class Header3TextModifier : TextModifier() {

    init {
        fontWeight(FontWeight.W700)
        textSize(16.sp)
    }

}

class Header4TextModifier : TextModifier() {

    init {
        fontWeight(FontWeight.W800)
        textSize(17.sp)
    }

}

class Header5TextModifier : TextModifier() {

    init {
        fontWeight(FontWeight.Bold)
        textSize(18.sp)
    }

}