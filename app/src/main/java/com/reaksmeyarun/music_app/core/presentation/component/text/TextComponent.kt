package com.reaksmeyarun.music_app.core.presentation.component.text

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    text: String,
    modifier: Modifier = Modifier,
    textModifier: TextModifier = TextModifier()
) {
    Text(
        text = text,
        color = textModifier.color,
        fontSize = textModifier.textSize,
        maxLines = textModifier.maxLines,
        minLines = textModifier.minLines,
        fontWeight = textModifier.fontWeight,
        textAlign = textModifier.textAlign,
        modifier = modifier,
        style = textModifier.style ?: LocalTextStyle.current
    )
}

@Composable
fun TextComponent(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    textModifier: TextModifier = TextModifier()
) {
    Text(
        text = text,
        color = textModifier.color,
        fontSize = textModifier.textSize,
        maxLines = textModifier.maxLines,
        minLines = textModifier.minLines,
        fontWeight = textModifier.fontWeight,
        textAlign = textModifier.textAlign,
        modifier = modifier,
        style = textModifier.style ?: LocalTextStyle.current
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewNormalTextComponent() {
    TextComponent(
        text = "Text Component",
        textModifier = TextModifier()
            .color(Color.Red)
            .fontWeight(FontWeight.Bold)
            .textSize(24.sp)
    )
}