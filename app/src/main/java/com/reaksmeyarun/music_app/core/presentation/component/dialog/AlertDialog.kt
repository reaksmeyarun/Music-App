package com.reaksmeyarun.music_app.core.presentation.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.core.presentation.component.button.ButtonModifier
import com.reaksmeyarun.music_app.core.presentation.component.button.ButtonComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.Header5TextModifier
import com.reaksmeyarun.music_app.core.presentation.component.text.SmallTextModifier
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme


@Preview(showBackground = true)
@Composable
fun PreviewAlertDialog() {
    MusicAppTheme {
        AlertDialog(title = "Alert Dialog", desc = "JetWeatherForecastTheme JetWeatherForecastTheme JetWeatherForecastTheme JetWeatherForecastTheme JetWeatherForecastTheme", state = remember {
            mutableStateOf(true)
        })
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialog(
    title: String,
    desc: String,
    state: MutableState<Boolean>
) {
    if (state.value) AlertDialog(
        onDismissRequest = { state.value = false },
        modifier = Modifier.clip(RoundedCornerShape(24.dp))
    ) {
        Surface(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
            ) {
                TextComponent(
                    text = title,
                    textModifier = Header5TextModifier()
                        .color(Color.White)
                )
                Spacer(modifier = Modifier.height(12.dp))
                TextComponent(
                    text = desc,
                    textModifier = SmallTextModifier()
                        .color(Color.White)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    ButtonComponent(
                        value = "Close",
                        buttonModifier = ButtonModifier()
                            .textColor(Color.White)
                            .buttonColors(Color.Transparent)
                            .contentPaddingHorizontal(8.dp),
                        onClick = {
                            state.value = false
                        }
                    )
                }
            }
        }
    }
}