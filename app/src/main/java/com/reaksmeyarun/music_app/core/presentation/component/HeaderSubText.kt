package com.reaksmeyarun.music_app.core.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.ui.theme.TextColor

@Preview(showBackground = true)
@Composable
fun PreviewSubHeaderText() {
    HeaderSubText("TextView")
}

@Composable
fun HeaderSubText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.W300,
    textSize: TextUnit = 15.sp,
    color: Color = TextColor,
    maxLines: Int = 1,
    textAlign: TextAlign = TextAlign.Start,
    isSelected: Boolean = true
) {
    NormalText(
        text = text,
        color = color,
        textSize = textSize,
        maxLines = maxLines,
        fontWeight = fontWeight,
        textAlign = textAlign,
        isSelected = isSelected,
        modifier = modifier
            .padding(vertical = 4.dp)
    )
}