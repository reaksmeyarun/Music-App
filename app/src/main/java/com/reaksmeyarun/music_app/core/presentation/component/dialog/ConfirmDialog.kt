package com.reaksmeyarun.music_app.core.presentation.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.reaksmeyarun.music_app.core.presentation.component.button.ButtonModifier
import com.reaksmeyarun.music_app.core.presentation.component.button.ButtonComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.Header5TextModifier
import com.reaksmeyarun.music_app.core.presentation.component.text.SmallTextModifier
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewConfirmDialog() {
    MusicAppTheme {
        ConfirmDialog(
            true,
            "Confirm Dialog",
            "Open Microsoft Teams and go to the Apps tab. Search for \"Incoming Webhook\" and select the Incoming Webhook connector. Select the \"Add to a team\" button to add the connector to the Team or Team channel name site where you want to send notifications.",
        ) {

        }
    }
}

enum class EDialogStatus {
    Dismiss,
    Yes,
    No
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmDialog(
    state: Boolean,
    title: String,
    desc: String,
    textCancel: String = "Cancel",
    textConfirm: String = "Confirm",
    eventListener: (EDialogStatus) -> Unit
) {
    if (state)
        AlertDialog(
            onDismissRequest = { eventListener.invoke(EDialogStatus.Dismiss) },
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .fillMaxWidth(0.9f),
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false // Set to false to control width manually
            )
        ) {
            Surface(
                modifier = Modifier.wrapContentHeight()
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    TextComponent(
                        text = title,
                        textModifier = Header5TextModifier()
                            .color(Color.White)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    TextComponent(
                        text = desc,
                        textModifier = SmallTextModifier()
                            .color(Color.White)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        ButtonComponent(
                            value = textCancel,
                            buttonModifier = ButtonModifier()
                                .textColor(Color.White)
                                .buttonColors(Color.Transparent)
                                .contentPaddingHorizontal(8.dp),
                            onClick = {
                                eventListener.invoke(EDialogStatus.No)
                            }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        ButtonComponent(
                            value = textConfirm,
                            buttonModifier = ButtonModifier()
                                .textColor(Color.White)
                                .buttonColors(Color.Transparent)
                                .contentPaddingHorizontal(8.dp),
                            onClick = {
                                eventListener.invoke(EDialogStatus.Yes)
                            }
                        )
                    }
                }
            }
        }
}