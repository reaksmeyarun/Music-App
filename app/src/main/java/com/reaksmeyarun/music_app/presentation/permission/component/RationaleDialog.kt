package com.reaksmeyarun.music_app.presentation.permission.component

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.csv.RuntimePermissionModel
import com.reaksmeyarun.music_app.core.presentation.component.dialog.ConfirmDialog
import com.reaksmeyarun.music_app.core.presentation.component.dialog.EDialogStatus
import com.reaksmeyarun.music_app.presentation.permission.PermissionEvent

@Composable
internal fun RationaleDialog(
    state: RuntimePermissionModel,
    onEvent: (PermissionEvent) -> Unit
) {
    val title = when (state.permission) {
        Manifest.permission.POST_NOTIFICATIONS -> stringResource(R.string.rationale_notification_title)
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.READ_MEDIA_AUDIO -> stringResource(R.string.rationale_read_storage_title)

        else -> stringResource(R.string.n_a)
    }
    val desc = when (state.permission) {
        Manifest.permission.POST_NOTIFICATIONS -> stringResource(R.string.rationale_notification_desc)
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.READ_MEDIA_AUDIO -> stringResource(R.string.rationale_read_storage_desc)

        else -> stringResource(R.string.n_a)
    }
    val buttonMessage = stringResource(R.string.go_to_setting)
    ConfirmDialog(
        state = state.isRationale,
        title = title,
        desc = desc,
        textConfirm = buttonMessage,
        eventListener = {
            when (it) {
                EDialogStatus.Yes -> onEvent(PermissionEvent.GoToSetting)
                EDialogStatus.Dismiss,
                EDialogStatus.No -> onEvent(PermissionEvent.DismissRationaleDialog)
            }
        }
    )
}