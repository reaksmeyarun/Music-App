package com.reaksmeyarun.music_app.core.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.ui.theme.Primary
import com.reaksmeyarun.music_app.ui.theme.Secondary

@Composable
@Preview(showBackground = true)
fun PreviewOutlinedTextField() {
    OutlinedTextField(
        fieldValue = "OutlinedTextFieldView",
        labelValue = "OutlinedTextFieldView",
        onValueChange = {

        }
    )
}

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    fieldValue: String = "",
    labelValue: String = "",
    maxLength: Int = Int.MAX_VALUE,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    singleLine: Boolean = when (keyboardType) {
        KeyboardType.Phone,
        KeyboardType.Password,
        KeyboardType.NumberPassword -> true
        else -> false
    },
    @DrawableRes leadingIcon: Int = when (keyboardType) {
        KeyboardType.Phone -> R.drawable.ic_phone
        KeyboardType.Password,
        KeyboardType.NumberPassword -> R.drawable.ic_password
        else -> -1
    },
    maxLines: Int = if (!singleLine)
        1
    else
        Int.MAX_VALUE,
    onValueChange: (value: String) -> Unit
) {
    val phonePattern = remember { Regex("^\\d+\$") }
    val passwordVisible = remember { mutableStateOf(false) }
    val leadingIconView = @Composable {
        Icon(
            painter = painterResource(leadingIcon),
            contentDescription = null
        )
    }
    val trailingIconView = @Composable {
        val image = painterResource(
            id = if (passwordVisible.value)
                R.drawable.ic_hide_password
            else
                R.drawable.ic_show_password
        )
        val description = stringResource(
            id = if (passwordVisible.value)
                R.string.hide_password
            else
                R.string.show_password
        )
        IconButton(
            onClick = {
                passwordVisible.value = !passwordVisible.value
            },
            content = {
                Icon(
                    painter = image,
                    contentDescription = description
                )
            }
        )
    }
    OutlinedTextField(
        value = fieldValue,
        textStyle = TextStyle(fontSize = 13.sp),
        singleLine = singleLine,
        maxLines = maxLines,
        onValueChange = {
            when (keyboardType) {
                KeyboardType.Phone ->
                    if ((it.isEmpty() || it.matches(phonePattern)) && it.length <= maxLength)
                        onValueChange.invoke(it)

                else -> if (it.length <= maxLength)
                    onValueChange.invoke(it)
            }
        },
        label = {
            TextComponent(text = labelValue)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = when (keyboardType) {
            KeyboardType.Password, KeyboardType.NumberPassword ->
                if (passwordVisible.value)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation()

            else -> VisualTransformation.None
        },
        leadingIcon = if (leadingIcon != -1)
            leadingIconView
        else
            null,
        trailingIcon = if (keyboardType == KeyboardType.Password || keyboardType == KeyboardType.NumberPassword)
            trailingIconView
        else
            null,
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            unfocusedBorderColor = Secondary,
            focusedLabelColor = Primary,
            unfocusedLabelColor = Secondary,
        ),
        modifier = modifier
            .fillMaxWidth()
            .requiredHeightIn(54.dp)
    )
}