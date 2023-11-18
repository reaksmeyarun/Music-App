package com.reaksmeyarun.music_app.presentation.permission.component

import android.Manifest
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.csv.EPermissionStatus
import com.reaksmeyarun.music_app.core.csv.RuntimePermissionModel
import com.reaksmeyarun.music_app.core.csv.painter
import com.reaksmeyarun.music_app.core.csv.specificBold
import com.reaksmeyarun.music_app.core.presentation.component.text.Body1TextModifier
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.SmallTextModifier
import com.reaksmeyarun.music_app.ui.theme.HolderBackground

@Composable
internal fun ComponentPermission(
    permission: RuntimePermissionModel,
    @DrawableRes
    res: Int,
    onClick: () -> Unit
) {
    val status = permission.status
    val isEnable = when (status) {
        EPermissionStatus.PermissionNoGrant,
        EPermissionStatus.PermissionDenied -> true

        EPermissionStatus.PermissionGrant -> false
    }
    val desc = when (permission.permission) {
        Manifest.permission.POST_NOTIFICATIONS -> stringResource(R.string.allow_music_app_to_send_you_notification)
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_MEDIA_AUDIO -> stringResource(
            R.string.allow_music_app_to_access_storage_on_your_device
        )

        else -> stringResource(R.string.n_a)
    }
    Column(
        modifier = Modifier
            .clickable(enabled = isEnable) {
                onClick.invoke()
            }
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Image(
                painter = painter(id = res),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            TextComponent(
                text = specificBold(
                    originalValue = desc,
                    value = stringResource(id = R.string.music_app)
                ),
                textModifier = Body1TextModifier()
                    .minLines(2),
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .weight(weight = 1f, fill = true)
            )
            Image(
                painter = painter(id = R.drawable.ic_left_arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .alpha(
                        alpha = if (status == EPermissionStatus.PermissionGrant)
                            0f
                        else
                            1f
                    )
            )
            Spacer(modifier = Modifier.width(24.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextComponent(
            text = status.message,
            textModifier = SmallTextModifier()
                .alignCenter(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(HolderBackground)
                .padding(vertical = 6.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview
@Composable
fun PreviewComponentPermission() {
    ComponentPermission(permission = RuntimePermissionModel(), res = R.drawable.ic_notification) {
        
    }
}