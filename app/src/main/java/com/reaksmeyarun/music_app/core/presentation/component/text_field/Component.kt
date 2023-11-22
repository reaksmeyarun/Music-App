package com.reaksmeyarun.music_app.core.presentation.component.text_field

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.presentation.component.IconButton
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.TextModifier
import com.reaksmeyarun.music_app.core.presentation.component.text_field.model.TextFieldModifier

@Composable
fun ErrorTextFieldComponent(textFieldModifier: TextFieldModifier, modifier: Modifier = Modifier) {
    TextComponent(
        text = textFieldModifier.errorMessage,
        modifier = modifier,
        textModifier = TextModifier().textSize(10.sp).color(textFieldModifier.errorColor)
    )
}

@Composable
fun LabelOutlinedTextFieldComponent(
    label: String?, textFieldModifier: TextFieldModifier
) {
    TextComponent(
        text = label ?: "",
        modifier = Modifier.background(Color.Transparent),
        textModifier = TextModifier().color(
            if (textFieldModifier.isError)
                textFieldModifier.errorColor
            else
                textFieldModifier.unfocusedPlaceHolderColor
        ).textSize(textFieldModifier.textSize)
    )
}

@Composable
fun LabelTextFieldComponent(
    value: String?, textFieldModifier: TextFieldModifier, modifier: Modifier = Modifier
) {
    TextComponent(
        text = value ?: "",
        modifier = modifier.background(Color.Transparent),
        textModifier = TextModifier().color(
            color = if (textFieldModifier.isError) textFieldModifier.errorColor
            else textFieldModifier.unfocusedPlaceHolderColor
        ).textSize(10.sp)
    )
}

@Composable
fun PlaceHolderBasicTextFieldComponent(
    value: String?, modifier: Modifier = Modifier, textFieldModifier: TextFieldModifier
) {
    TextComponent(
        text = value ?: "",
        modifier = modifier.background(Color.Transparent),
        textModifier = TextModifier().color(
            color = if (textFieldModifier.isError) textFieldModifier.errorColor
            else textFieldModifier.unfocusedPlaceHolderColor
        ).textSize(textFieldModifier.textSize)
    )
}

@Composable
fun TrialingComponent(keyboardType: KeyboardType, @DrawableRes res: Int, onClick: () -> Unit) {
    val passwordVisible = remember { mutableStateOf(false) }
    val image =
        if (keyboardType == KeyboardType.Password || keyboardType == KeyboardType.NumberPassword) {
            if (passwordVisible.value) R.drawable.ic_hide_password
            else R.drawable.ic_show_password
        } else res
    val description = stringResource(
        id = if (passwordVisible.value) R.string.hide_password
        else R.string.show_password
    )
    IconButton(res = image, content = description, onButtonClicked = {
        if (keyboardType == KeyboardType.Password || keyboardType == KeyboardType.NumberPassword) passwordVisible.value =
            !passwordVisible.value
        else onClick.invoke()
    })
}

@Composable
fun PrefixComponent(textFieldModifier: TextFieldModifier) {
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