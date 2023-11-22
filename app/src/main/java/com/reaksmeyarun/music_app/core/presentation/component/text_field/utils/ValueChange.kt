package com.reaksmeyarun.music_app.core.presentation.component.text_field.utils

import androidx.compose.ui.text.input.KeyboardType

fun restrictionKeyboardType(
    value: String,
    maxLength: Int,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {
    val regex = Regex("^\\d+\$")
    when (keyboardType) {
        KeyboardType.Phone ->
            if ((value.isEmpty() || value.matches(regex)) && value.length <= maxLength)
                onValueChange.invoke(value)

        else -> if (value.length <= maxLength)
            onValueChange.invoke(value)
    }
}