package com.reaksmeyarun.music_app.core.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewIconButton() {
    MusicAppTheme {
        IconButton(
            res = R.drawable.baseline_arrow_back_ios_24
        ) {

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconButton(
    @DrawableRes res: Int,
    modifier: Modifier = Modifier,
    color: Color? = null,
    content: String? = null,
    onButtonClicked: () -> Unit
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
        IconButton(
            onClick = onButtonClicked,
            modifier = modifier
        ) {
            color?.let {
                Icon(
                    painter = painterResource(res),
                    tint = color,
                    contentDescription = content,
                    modifier = modifier.size(24.dp)
                )
            } ?: Icon(
                painter = painterResource(res),
                contentDescription = content,
                modifier = modifier.size(24.dp)
            )
        }
    }
}