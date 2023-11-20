package com.reaksmeyarun.music_app.core.presentation.component.edit_text

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.ui.theme.TextColor

open class TextFieldModifier {

    var visualTransformation: VisualTransformation = VisualTransformation.None
        private set
    var focusedContainerColor: Color = Color.Transparent
        private set
    var unfocusedContainerColor: Color = Color.Transparent
        private set
    var disabledContainerColor: Color = Color.Transparent
        private set
    var focusedIndicatorColor: Color = Color.Transparent
        private set
    var unfocusedIndicatorColor: Color = Color.Transparent
        private set
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
    var enabled: Boolean = true
        private set
    var readOnly: Boolean = false
        private set
    var isError: Boolean = false
        private set
    var placeHolderColor: Color = TextColor.copy(0.5f)
        private set
    var errorMessage: String = ""
        private set
    var errorColor: Color = Color.Red
        private set
    var singleLine: Boolean = false
        private set
    var keyboardOptions: KeyboardOptions? = null
        private set
    var keyboardActions: KeyboardActions? = null
        private set
    var prefix: String = ""
        private set
    var suffix: String = ""
        private set
    var prefixColor: Color = TextColor
        private set
    var contentPaddingStart: Dp = 0.dp
        private set
    var contentPaddingEnd: Dp = 0.dp
        private set
    var contentPaddingTop: Dp = 16.dp
        private set
    var contentPaddingBottom: Dp = 16.dp
        private set

    fun contentPadding(
        start: Dp = contentPaddingStart,
        top: Dp = contentPaddingEnd,
        end: Dp = contentPaddingTop,
        bottom: Dp = contentPaddingBottom
    ) = this.apply {
        this.contentPaddingStart = start
        this.contentPaddingEnd = top
        this.contentPaddingTop = end
        this.contentPaddingBottom = bottom
    }

    fun contentPadding(
        vertical: Dp = contentPaddingTop,
        horizontal: Dp = contentPaddingStart
    ) = this.apply {
        this.contentPaddingStart = horizontal
        this.contentPaddingEnd = horizontal
        this.contentPaddingTop = vertical
        this.contentPaddingBottom = vertical
    }

    fun suffix(suffix: String) = this.apply {
        this.suffix = suffix
    }

    fun prefix(prefix: String) = this.apply {
        this.prefix = prefix
    }

    fun prefixColor(color: Color) = this.apply {
        this.prefixColor = prefixColor
    }

    fun isError(status: Boolean) = this.apply {
        if (!status)
            errorMessage = ""
        this.isError = status
    }

    fun enable(status: Boolean) = this.apply {
        this.enabled = status
    }

    fun readOnly(status: Boolean) = this.apply {
        this.readOnly = status
    }

    fun visualTransformation(visualTransformation: VisualTransformation) = this.apply {
        this.visualTransformation = visualTransformation
    }

    fun focusedIndicatorColor(color: Color) = this.apply {
        this.focusedIndicatorColor = color
    }

    fun focusedContainerColor(color: Color) = this.apply {
        this.focusedContainerColor = color
    }

    fun unfocusedContainerColor(color: Color) = this.apply {
        this.unfocusedContainerColor = color
    }

    fun disabledContainerColor(color: Color) = this.apply {
        this.disabledContainerColor = color
    }

    fun unfocusedIndicatorColor(color: Color) = this.apply {
        this.unfocusedIndicatorColor = color
    }

    fun color(color: Color) = this.apply {
        this.color = color
    }

    fun fontWeight(fontWeight: FontWeight) = this.apply {
        this.fontWeight = fontWeight
    }

    fun textSize(textSize: TextUnit) = this.apply {
        this.textSize = textSize
    }

    open fun maxLines(maxLines: Int) = this.apply {
        this.singleLine = maxLines == 1
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

    fun keyboardType(keyboardType: KeyboardType) = this.apply {
        this.keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
    }

    fun keyboardActions(keyboardActions: KeyboardActions) = this.apply {
        this.keyboardActions = keyboardActions
    }

    fun placeHolderColor(color: Color) = this.apply {
        this.placeHolderColor = color
    }

    fun errorMessage(errorMessage: String) = this.apply {
        if (errorMessage.isNotEmpty())
            isError = true
        this.errorMessage = errorMessage
    }

    fun errorColor(color: Color) = this.apply {
        this.errorColor = color
    }

    fun singleLine(status: Boolean) = this.apply {
        val maxLines = if (status)
            1
        else
            Int.MAX_VALUE
        maxLines(maxLines)
        this.singleLine = status
    }

}
