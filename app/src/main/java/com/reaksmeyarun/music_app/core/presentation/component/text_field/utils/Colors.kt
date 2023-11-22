package com.reaksmeyarun.music_app.core.presentation.component.text_field.utils

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.reaksmeyarun.music_app.core.presentation.component.text_field.model.TextFieldModifier

@Composable
fun OutlinedTextFieldDefaults.colors(textFieldModifier: TextFieldModifier) = colors(
    cursorColor = textFieldModifier.color,
    focusedTextColor = textFieldModifier.color,
    unfocusedTextColor = textFieldModifier.color,
    errorLabelColor = textFieldModifier.errorColor,
    errorTextColor = textFieldModifier.errorColor,
    errorContainerColor = textFieldModifier.focusedContainerColor,
    focusedContainerColor = textFieldModifier.focusedContainerColor,
    unfocusedContainerColor = textFieldModifier.unfocusedContainerColor,
    disabledContainerColor = textFieldModifier.disabledContainerColor,
    focusedBorderColor = textFieldModifier.focusedBorderColor,
    unfocusedBorderColor = textFieldModifier.unfocusedBorderColor,
    focusedLabelColor = textFieldModifier.focusedLabelColor,
    unfocusedLabelColor = textFieldModifier.unfocusedLabelColor,
    focusedPlaceholderColor = textFieldModifier.unfocusedPlaceHolderColor,
    unfocusedPlaceholderColor = textFieldModifier.unfocusedPlaceHolderColor,
)

@Composable
fun TextFieldDefaults.colors(textFieldModifier: TextFieldModifier) = colors(
    cursorColor = textFieldModifier.color,
    focusedTextColor = textFieldModifier.color,
    unfocusedTextColor = textFieldModifier.color,
    errorLabelColor = textFieldModifier.errorColor,
    errorTextColor = textFieldModifier.errorColor,
    errorContainerColor = textFieldModifier.focusedContainerColor,
    focusedContainerColor = textFieldModifier.focusedContainerColor,
    unfocusedContainerColor = textFieldModifier.unfocusedContainerColor,
    disabledContainerColor = textFieldModifier.disabledContainerColor,
    focusedLabelColor = textFieldModifier.focusedLabelColor,
    unfocusedLabelColor = textFieldModifier.unfocusedLabelColor,
    focusedIndicatorColor = textFieldModifier.focusedIndicatorColor,
    unfocusedIndicatorColor = textFieldModifier.unfocusedIndicatorColor,
    errorIndicatorColor = textFieldModifier.errorColor,
    disabledIndicatorColor = textFieldModifier.disabledIndicatorColor,
    focusedPlaceholderColor = textFieldModifier.focusedPlaceHolderColor,
    unfocusedPlaceholderColor = textFieldModifier.unfocusedPlaceHolderColor
)

@Composable
fun TextFieldDefaults.basicTextFieldColors(textFieldModifier: TextFieldModifier) = colors(
    cursorColor = textFieldModifier.color,
    focusedTextColor = textFieldModifier.color,
    unfocusedTextColor = textFieldModifier.color,
    errorLabelColor = textFieldModifier.errorColor,
    errorTextColor = textFieldModifier.errorColor,
    errorContainerColor = textFieldModifier.focusedContainerColor,
    focusedContainerColor = textFieldModifier.focusedContainerColor,
    unfocusedContainerColor = textFieldModifier.unfocusedContainerColor,
    disabledContainerColor = textFieldModifier.disabledContainerColor,
    focusedLabelColor = textFieldModifier.focusedLabelColor,
    unfocusedLabelColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = textFieldModifier.unfocusedIndicatorColor,
    errorIndicatorColor = Color.Transparent
)