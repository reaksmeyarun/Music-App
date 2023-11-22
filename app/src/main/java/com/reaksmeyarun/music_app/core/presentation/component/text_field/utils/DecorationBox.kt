package com.reaksmeyarun.music_app.core.presentation.component.text_field.utils

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.reaksmeyarun.music_app.core.csv.painter
import com.reaksmeyarun.music_app.core.presentation.component.text_field.LabelTextFieldComponent
import com.reaksmeyarun.music_app.core.presentation.component.text_field.PlaceHolderBasicTextFieldComponent
import com.reaksmeyarun.music_app.core.presentation.component.text_field.PrefixComponent
import com.reaksmeyarun.music_app.core.presentation.component.text_field.TrialingComponent
import com.reaksmeyarun.music_app.core.presentation.component.text_field.model.TextFieldModifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTextFieldComponentDecorationBox(
    value: String,
    placeholder: String,
    textFieldModifier: TextFieldModifier,
    interactionSource: MutableInteractionSource,
    innerTextField: @Composable () -> Unit,
    trialingClick: () -> Unit
) {
    TextFieldDefaults.DecorationBox(
        value = value,
        visualTransformation = textFieldModifier.visualTransformation,
        innerTextField = innerTextField,
        placeholder = {
            PlaceHolderBasicTextFieldComponent(
                value = placeholder,
                textFieldModifier = textFieldModifier
            )
        },
        label = null,
        trailingIcon = if (textFieldModifier.trailingRes != -1) {
            @Composable {
                TrialingComponent(
                    keyboardType = textFieldModifier.keyboardType,
                    res = textFieldModifier.trailingRes,
                    onClick = trialingClick
                )
            }
        } else null,
        leadingIcon = if (textFieldModifier.leadingRes != -1) {
            @Composable {
                Icon(
                    painter = painter(id = textFieldModifier.leadingRes),
                    contentDescription = null
                )
            }
        } else null,
        prefix = if (textFieldModifier.prefix.isNotEmpty()) {
            @Composable {
                PrefixComponent(textFieldModifier = textFieldModifier)
            }
        } else null,
        suffix = if (textFieldModifier.suffix.isNotEmpty()) {
            @Composable {
                PrefixComponent(textFieldModifier = textFieldModifier)
            }
        } else null,
        supportingText = null,
        shape = TextFieldDefaults.shape,
        singleLine = textFieldModifier.singleLine,
        enabled = textFieldModifier.enabled,
        isError = textFieldModifier.isError,
        interactionSource = interactionSource,
        colors = TextFieldDefaults.basicTextFieldColors(textFieldModifier = textFieldModifier),
        contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
            start = textFieldModifier.contentPaddingStart,
            top = textFieldModifier.contentPaddingTop,
            end = textFieldModifier.contentPaddingEnd,
            bottom = textFieldModifier.contentPaddingBottom
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponentDecorationBox(
    value: String,
    placeholder: String,
    textFieldModifier: TextFieldModifier,
    interactionSource: MutableInteractionSource,
    innerTextField: @Composable () -> Unit,
    trialingClick: () -> Unit
) {
    TextFieldDefaults.DecorationBox(
        value = value,
        visualTransformation = textFieldModifier.visualTransformation,
        innerTextField = innerTextField,
        placeholder = if (value.isEmpty()) {
            @Composable {
                LabelTextFieldComponent(
                    value = placeholder,
                    textFieldModifier = textFieldModifier
                )
            }
        } else null,
        label = if (value.isNotEmpty()) {
            @Composable {
                LabelTextFieldComponent(
                    value = placeholder,
                    textFieldModifier = textFieldModifier
                )
            }
        } else null,
        trailingIcon = if (textFieldModifier.trailingRes != -1) {
            @Composable {
                TrialingComponent(
                    keyboardType = textFieldModifier.keyboardType,
                    res = textFieldModifier.trailingRes,
                    onClick = trialingClick
                )
            }
        } else null,
        leadingIcon = if (textFieldModifier.leadingRes != -1) {
            @Composable {
                Icon(
                    painter = painter(id = textFieldModifier.leadingRes),
                    contentDescription = null
                )
            }
        } else null,
        prefix = if (textFieldModifier.prefix.isNotEmpty()) {
            @Composable {
                PrefixComponent(textFieldModifier = textFieldModifier)
            }
        } else null,
        suffix = if (textFieldModifier.suffix.isNotEmpty()) {
            @Composable {
                PrefixComponent(textFieldModifier = textFieldModifier)
            }
        } else null,
        supportingText = null,
        shape = TextFieldDefaults.shape,
        singleLine = textFieldModifier.singleLine,
        enabled = textFieldModifier.enabled,
        isError = textFieldModifier.isError,
        interactionSource = interactionSource,
        colors = TextFieldDefaults.colors(textFieldModifier = textFieldModifier),
        contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
            start = textFieldModifier.contentPaddingStart,
            top = textFieldModifier.contentPaddingTop,
            end = textFieldModifier.contentPaddingEnd,
            bottom = textFieldModifier.contentPaddingBottom
        )
    )
}
