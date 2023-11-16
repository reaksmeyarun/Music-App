package com.reaksmeyarun.music_app.core.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.ui.theme.Primary

@Composable
@Preview(showBackground = true)
fun ButtonPreview() {
    Button(value = "ButtonView")
}

@Composable
fun Button(
    value: String,
    modifier: Modifier = Modifier,
    textColor: Color = White,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(Primary),
    radius: Dp = 12.dp,
    contentPaddingVertical: Dp = 8.dp,
    contentPaddingHorizontal: Dp = 16.dp,
    padding: Dp = 0.dp,
    onClick: () -> Unit = {}
) {
    Button(
        colors = buttonColors,
        shape = RoundedCornerShape(radius),
        contentPadding = PaddingValues(
            horizontal = contentPaddingHorizontal,
            vertical = contentPaddingVertical
        ), modifier = modifier
            .padding(padding)
        , onClick = {
            onClick.invoke()
        }
    ) {
        NormalText(
            text = value,
            textSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
    }
}