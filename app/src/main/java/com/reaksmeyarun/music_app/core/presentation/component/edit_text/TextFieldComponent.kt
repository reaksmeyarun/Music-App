package com.reaksmeyarun.music_app.core.presentation.component.edit_text

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.TextModifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier? = Modifier,
    textFieldModifier: TextFieldModifier = TextFieldModifier(),
) {
    val interactionSource = remember { MutableInteractionSource() }
    val colors: TextFieldColors = TextFieldDefaults.colors(
        errorContainerColor = textFieldModifier.focusedContainerColor,
        errorIndicatorColor = textFieldModifier.focusedContainerColor,
        focusedContainerColor = textFieldModifier.focusedContainerColor,
        unfocusedContainerColor = textFieldModifier.unfocusedContainerColor,
        disabledContainerColor = textFieldModifier.disabledContainerColor,
        focusedIndicatorColor = textFieldModifier.focusedIndicatorColor,
        unfocusedIndicatorColor = textFieldModifier.unfocusedIndicatorColor
    )
    BasicTextField(
        value = value,
        modifier = modifier ?: Modifier.fillMaxWidth(),
        onValueChange = onValueChange,
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
        visualTransformation = textFieldModifier.visualTransformation,
        keyboardOptions = textFieldModifier.keyboardOptions ?: KeyboardOptions.Default,
        keyboardActions = textFieldModifier.keyboardActions ?: KeyboardActions.Default,
        interactionSource = interactionSource,
        singleLine = textFieldModifier.singleLine,
        maxLines = textFieldModifier.maxLines,
        minLines = textFieldModifier.minLines,
        decorationBox = @Composable { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                visualTransformation = textFieldModifier.visualTransformation,
                innerTextField = innerTextField,
                placeholder = {
                    TextComponent(
                        text = placeholder,
                        textModifier = TextModifier()
                            .fontWeight(textFieldModifier.fontWeight)
                            .textSize(textFieldModifier.textSize)
                            .maxLines(textFieldModifier.maxLines)
                            .minLines(textFieldModifier.minLines)
                            .textAlign(textFieldModifier.textAlign)
                            .isSelected(textFieldModifier.isSelected)
                            .color(textFieldModifier.placeHolderColor)
                            .style(textFieldModifier.style)
                    )
                },
                label = null,
                leadingIcon = null,
                trailingIcon = null,
                prefix = if (textFieldModifier.prefix.isEmpty()) null else {
                    {
                        TextComponent(
                            text = textFieldModifier.prefix,
                            modifier = Modifier.padding(end = 4.dp),
                            textModifier = TextModifier()
                                .fontWeight(textFieldModifier.fontWeight)
                                .textSize(textFieldModifier.textSize)
                                .maxLines(textFieldModifier.maxLines)
                                .minLines(textFieldModifier.minLines)
                                .textAlign(textFieldModifier.textAlign)
                                .isSelected(textFieldModifier.isSelected)
                                .color(textFieldModifier.prefixColor)
                                .style(textFieldModifier.style)
                        )
                    }
                },
                suffix = if (textFieldModifier.suffix.isEmpty()) null else {
                    {
                        TextComponent(
                            text = textFieldModifier.suffix,
                            modifier = Modifier.padding(start = 4.dp),
                            textModifier = TextModifier()
                                .fontWeight(textFieldModifier.fontWeight)
                                .textSize(textFieldModifier.textSize)
                                .maxLines(textFieldModifier.maxLines)
                                .minLines(textFieldModifier.minLines)
                                .textAlign(textFieldModifier.textAlign)
                                .isSelected(textFieldModifier.isSelected)
                                .color(textFieldModifier.prefixColor)
                                .style(textFieldModifier.style)
                        )
                    }
                },
                supportingText = if (textFieldModifier.errorMessage.isEmpty())
                    null
                else {
                    {
                        TextComponent(
                            text = textFieldModifier.errorMessage,
                            textModifier = TextModifier()
                                .textSize(10.sp)
                                .color(textFieldModifier.errorColor)
                        )
                    }
                },
                shape = TextFieldDefaults.shape,
                singleLine = textFieldModifier.singleLine,
                enabled = textFieldModifier.enabled,
                isError = textFieldModifier.isError,
                interactionSource = interactionSource,
                colors = colors,
                contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                    start = textFieldModifier.contentPaddingStart,
                    top = textFieldModifier.contentPaddingTop,
                    end = textFieldModifier.contentPaddingEnd,
                    bottom = textFieldModifier.contentPaddingBottom
                )
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBasicTextFieldComponent() {
    TextFieldComponent(
        value = "TextField Component",
        placeholder = "TextField Component",
        onValueChange = {

        },
        modifier = Modifier.wrapContentWidth(),
        textFieldModifier = TextFieldModifier()
            .placeHolderColor(Color.Red)
            .keyboardType(KeyboardType.Email)
            .keyboardActions(KeyboardActions(
                onDone = {

                }
            ))
            .maxLines(3)
            .prefix("(+855)")
    )
}