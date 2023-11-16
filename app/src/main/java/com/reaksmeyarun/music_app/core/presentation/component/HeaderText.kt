package com.reaksmeyarun.music_app.core.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.ui.theme.TextColor

@Preview(showBackground = true)
@Composable
fun PreviewHeaderTextComponent() {
    HeaderText("TextView")
}

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Bold,
    textSize: TextUnit = 18.sp,
    color: Color = TextColor,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start,
    isSelected: Boolean = true
) {
    NormalText(
        text = text,
        color = color,
        textSize = textSize,
        maxLines = maxLines,
        fontWeight = fontWeight,
        isSelected = isSelected,
        textAlign = textAlign,
        modifier = modifier
    )
}