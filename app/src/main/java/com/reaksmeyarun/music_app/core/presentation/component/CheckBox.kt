package com.reaksmeyarun.music_app.core.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent

@Composable
fun CheckBox(
    text: String,
    checked: Boolean = false,
    onCheckedChange: ((isChecked: Boolean) -> Unit)
) {
    val checkedState = remember {
        mutableStateOf(checked)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = it
                onCheckedChange.invoke(it)
            }
        )
        TextComponent(text = text)
    }
}