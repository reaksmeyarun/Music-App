package com.reaksmeyarun.music_app.core.csv

import androidx.compose.ui.graphics.Color
import com.reaksmeyarun.music_app.ui.theme.TextColor

fun Boolean.getSelectColor(color: Color = TextColor) = if (this)
    color
else
    color.copy(0.25f)