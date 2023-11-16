package com.reaksmeyarun.music_app.presentation.permission.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.presentation.component.IconButton
import com.reaksmeyarun.music_app.core.presentation.component.NormalText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ComponentTopAppBar() {
    TopAppBar(
        title = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NormalText(
                        fontWeight = FontWeight.Bold,
                        textSize = 32.sp,
                        text = stringResource(R.string.permissions),
                        color = Color.White,
                        modifier = Modifier.weight(weight = 1f, fill = true)
                    )
                    IconButton(
                        res = R.drawable.ic_setting,
                        color = Color.White,
                        onButtonClicked = {

                        }
                    )
                }
                NormalText(
                    fontWeight = FontWeight.Bold,
                    textSize = 16.sp,
                    text = stringResource(R.string.require),
                    color = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Transparent,
        )
    )
}