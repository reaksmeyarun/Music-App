package com.reaksmeyarun.music_app.core.presentation.component

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.ui.theme.TextColor

@Preview(showBackground = true)
@Composable
fun PreviewNormalTextComponent() {
    NormalText("TextView")
}

@Composable
fun NormalText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.W300,
    textSize: TextUnit = 13.sp,
    color: Color = TextColor,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start,
    isSelected: Boolean = true,
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text = text,
        color = if (isSelected) color else color.copy(0.25f),
        fontSize = textSize,
        maxLines = maxLines,
        fontWeight = fontWeight,
        textAlign = textAlign,
        modifier = modifier,
        style = style
    )
}

@Composable
fun NormalText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.W300,
    textSize: TextUnit = 13.sp,
    color: Color = TextColor,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    textAlign: TextAlign = TextAlign.Start,
    isSelected: Boolean = true,
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text = text,
        color = if (isSelected) color else color.copy(0.25f),
        fontSize = textSize,
        maxLines = maxLines,
        minLines = minLines,
        fontWeight = fontWeight,
        textAlign = textAlign,
        modifier = modifier,
        style = style
    )
}