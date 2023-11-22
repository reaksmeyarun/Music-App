package com.reaksmeyarun.music_app.core.presentation.component.text_field

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.TextFieldComponentDecorationBox
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.restrictionKeyboardType
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.visualTransformation

@Composable
fun TextFieldComponent(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier? = Modifier,
    textTextFieldModifier: TextFieldModifier = TextFieldModifier(),
    trialingClick: () -> Unit = {}
) {
    val passwordVisible = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = (modifier ?: Modifier)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BasicTextField(
            value = value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                restrictionKeyboardType(
                    value = it,
                    maxLength = textTextFieldModifier.maxLength,
                    keyboardType = textTextFieldModifier.keyboardType,
                    onValueChange = onValueChange
                )
            },
            enabled = textTextFieldModifier.enabled,
            readOnly = textTextFieldModifier.readOnly,
            textStyle = LocalTextStyle.current.copy(
                color = textTextFieldModifier.color,
                fontSize = textTextFieldModifier.textSize,
                fontWeight = textTextFieldModifier.fontWeight
            ),
            cursorBrush = SolidColor(
                if (textTextFieldModifier.isError)
                    textTextFieldModifier.errorColor
                else
                    textTextFieldModifier.color
            ),
            visualTransformation = visualTransformation(
                keyboardType = textTextFieldModifier.keyboardType,
                status = passwordVisible.value
            ),
            keyboardOptions = textTextFieldModifier.keyboardOptions ?: KeyboardOptions.Default,
            keyboardActions = textTextFieldModifier.keyboardActions ?: KeyboardActions.Default,
            interactionSource = interactionSource,
            singleLine = textTextFieldModifier.singleLine,
            maxLines = textTextFieldModifier.maxLines,
            minLines = textTextFieldModifier.minLines,
            decorationBox = @Composable { innerTextField ->
                TextFieldComponentDecorationBox(
                    value = value,
                    placeholder = placeholder,
                    textFieldModifier = textTextFieldModifier,
                    interactionSource = interactionSource,
                    innerTextField = innerTextField,
                    trialingClick = trialingClick
                )
            }
        )
        if (textTextFieldModifier.errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(textTextFieldModifier.contentPaddingBottom / 2))
            ErrorTextFieldComponent(textFieldModifier = textTextFieldModifier)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewTextFieldComponent() {
    Row(
        modifier = Modifier.background(Color.Blue)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        TextFieldComponent(
            value = "TextField",
            placeholder = "Component",
            onValueChange = {

            },
            modifier = Modifier.weight(1f),
            textTextFieldModifier = TextFieldModifier()
                .keyboardType(KeyboardType.Email)
                .keyboardActions(
                    keyboardActions = KeyboardActions(
                        onDone = {

                        }
                    )
                ).maxLines(3).errorMessage("TextField Component*")
        )
        Spacer(modifier = Modifier.width(24.dp))
        TextFieldComponent(
            value = "",
            placeholder = "TextField Component",
            onValueChange = {

            },
            modifier = Modifier.weight(1f),
            textTextFieldModifier = TextFieldModifier()
                .keyboardType(KeyboardType.Email)
                .keyboardActions(keyboardActions = KeyboardActions(
                    onDone = {

                    }
                )
                ).maxLines(3)
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}