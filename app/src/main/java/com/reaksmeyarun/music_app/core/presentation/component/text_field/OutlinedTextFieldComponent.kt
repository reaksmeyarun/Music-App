package com.reaksmeyarun.music_app.core.presentation.component.text_field

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.core.csv.painter
import com.reaksmeyarun.music_app.core.presentation.component.text_field.model.TextFieldModifier
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.colors
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.restrictionKeyboardType
import com.reaksmeyarun.music_app.core.presentation.component.text_field.utils.visualTransformation

@Composable
fun OutlinedTextFieldComponent(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier? = Modifier,
    textFieldModifier: TextFieldModifier = TextFieldModifier(),
    trialingClick: () -> Unit = {}
) {
    textFieldModifier
        .focusedBorderColor(Color.White)
        .unfocusedBorderColor(Color.White)
        .focusedLabelColor(Color.White)
        .unfocusedLabelColor(Color.Gray)
        .focusedPlaceHolderColor(Color.White)
        .unfocusedPlaceHolderColor(Color.Gray)
    val passwordVisible = remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }
    OutlinedTextField(value = value,
        textStyle = LocalTextStyle.current.copy(
            color = textFieldModifier.color,
            fontSize = textFieldModifier.textSize,
            fontWeight = textFieldModifier.fontWeight
        ),
        singleLine = textFieldModifier.singleLine,
        maxLines = textFieldModifier.maxLines,
        onValueChange = {
            restrictionKeyboardType(
                value = it,
                maxLength = textFieldModifier.maxLength,
                keyboardType = textFieldModifier.keyboardType,
                onValueChange = onValueChange
            )
        },
        label = {
            LabelOutlinedTextFieldComponent(
                label = placeholder,
                textFieldModifier = textFieldModifier.color(
                    when {
                        textFieldModifier.isError -> textFieldModifier.errorColor
                        isFocused -> Color.White
                        else -> textFieldModifier.unfocusedLabelColor
                    }
                )
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = textFieldModifier.keyboardType),
        visualTransformation = visualTransformation(
            keyboardType = textFieldModifier.keyboardType, status = passwordVisible.value
        ),
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
        supportingText = if (textFieldModifier.errorMessage.isNotEmpty()) {
            @Composable {
                ErrorTextFieldComponent(textFieldModifier = textFieldModifier)
            }
        } else null,
        isError = textFieldModifier.isError,
        colors = OutlinedTextFieldDefaults.colors(textFieldModifier),
        modifier = (modifier ?: Modifier.fillMaxWidth())
            .width(IntrinsicSize.Min)
            .onFocusChanged {
                isFocused = it.isFocused
            }
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewOutlinedTextFieldComponent() {
    OutlinedTextFieldComponent(
        value = "",
        placeholder = "TextField Component",
        onValueChange = {

        },
        modifier = Modifier
            .background(Color.Blue)
            .wrapContentWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        textFieldModifier = TextFieldModifier().backgroundColor(Color.Red)
            .unfocusedPlaceHolderColor(Color.Red).keyboardType(KeyboardType.Email)
            .keyboardActions(KeyboardActions(onDone = {

            })).errorMessage("Require!").maxLines(3)
    )
}
