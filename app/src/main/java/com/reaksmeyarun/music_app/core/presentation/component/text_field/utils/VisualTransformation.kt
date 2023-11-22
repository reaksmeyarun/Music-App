package com.reaksmeyarun.music_app.core.presentation.component.text_field.utils

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

fun visualTransformation(keyboardType: KeyboardType, status: Boolean) =
    when (keyboardType) {
        KeyboardType.Password, KeyboardType.NumberPassword ->
            if (status)
                VisualTransformation.None
            else
                PasswordVisualTransformation()

        else -> VisualTransformation.None
    }