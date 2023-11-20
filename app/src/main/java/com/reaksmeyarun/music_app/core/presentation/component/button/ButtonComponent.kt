package com.reaksmeyarun.music_app.core.presentation.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.reaksmeyarun.music_app.core.presentation.component.text.ButtonTextModifier
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.ui.theme.Primary

@Composable
fun ButtonComponent(
    value: String,
    modifier: Modifier = Modifier,
    buttonModifier: ButtonModifier = ButtonModifier(),
    onClick: () -> Unit = {}
) {
    Button(
        colors = buttonColors(containerColor = buttonModifier.buttonColors ?: Primary),
        shape = RoundedCornerShape(buttonModifier.radius),
        contentPadding = PaddingValues(
            horizontal = buttonModifier.contentPaddingHorizontal,
            vertical = buttonModifier.contentPaddingVertical
        ),
        modifier = modifier
            .padding(buttonModifier.padding),
        onClick = {
            onClick.invoke()
        }
    ) {
        TextComponent(
            text = value,
            textModifier = ButtonTextModifier()
                .color(buttonModifier.textColor)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComponentButton() {
    ButtonComponent(
        "Button Component",
        buttonModifier = ButtonModifier()
            .buttonColors(Color.Red)
    )
}