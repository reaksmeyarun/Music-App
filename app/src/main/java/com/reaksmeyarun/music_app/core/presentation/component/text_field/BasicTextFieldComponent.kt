package com.reaksmeyarun.music_app.core.presentation.component.text_field

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.core.presentation.component.text_field.model.TextFieldModifier
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.BasicTextFieldComponentDecorationBox
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.restrictionKeyboardType
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.visualTransformation

@Composable
fun BasicTextFieldComponent(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier? = Modifier,
    textFieldModifier: TextFieldModifier = TextFieldModifier(),
    trialingClick: () -> Unit = {}
) {
    val passwordVisible = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier?.wrapContentHeight() ?: Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BasicTextField(
            value = value,
            modifier = modifier?.wrapContentHeight() ?: Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            ,
            onValueChange = {
                restrictionKeyboardType(
                    value = it,
                    maxLength = textFieldModifier.maxLength,
                    keyboardType = textFieldModifier.keyboardType,
                    onValueChange = onValueChange
                )
            },
            enabled = textFieldModifier.enabled,
            readOnly = textFieldModifier.readOnly,
            textStyle = LocalTextStyle.current.copy(
                color = textFieldModifier.color,
                fontSize = textFieldModifier.textSize,
                fontWeight = textFieldModifier.fontWeight
            ),
            cursorBrush = SolidColor(
                if (textFieldModifier.isError)
                    textFieldModifier.errorColor
                else
                    textFieldModifier.color
            ),
            visualTransformation = visualTransformation(
                keyboardType = textFieldModifier.keyboardType,
                status = passwordVisible.value
            ),
            keyboardOptions = textFieldModifier.keyboardOptions ?: KeyboardOptions.Default,
            keyboardActions = textFieldModifier.keyboardActions ?: KeyboardActions.Default,
            interactionSource = interactionSource,
            singleLine = textFieldModifier.singleLine,
            maxLines = textFieldModifier.maxLines,
            minLines = textFieldModifier.minLines,
            decorationBox = @Composable { innerTextField ->
                BasicTextFieldComponentDecorationBox(
                    value = value,
                    placeholder = placeholder,
                    textFieldModifier = textFieldModifier,
                    interactionSource = interactionSource,
                    innerTextField = innerTextField,
                    trialingClick = trialingClick
                )
            }
        )
        if (textFieldModifier.errorMessage.isNotEmpty())
            ErrorTextFieldComponent(textFieldModifier = textFieldModifier)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBasicTextFieldComponent() {
    BasicTextFieldComponent(
        value = "",
        placeholder = "TextField Component",
        onValueChange = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(Color.Black),
        textFieldModifier = TextFieldModifier()
            .keyboardType(KeyboardType.Email)
            .keyboardActions(KeyboardActions(
                onDone = {

                }
            ))
            .isError(true)
            .maxLines(3)
    )
}