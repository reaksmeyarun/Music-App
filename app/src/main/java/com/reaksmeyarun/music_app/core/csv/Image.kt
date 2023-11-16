package com.reaksmeyarun.music_app.core.csv

import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@Composable
fun imageVector(@DrawableRes id: Int) = ImageVector.vectorResource(id = id)

@Composable
fun painter(@DrawableRes id: Int) = rememberDrawablePainter(AppCompatResources.getDrawable(LocalContext.current, id))
