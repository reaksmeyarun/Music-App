package com.reaksmeyarun.music_app.presentation.permission

import android.os.Parcelable
import com.reaksmeyarun.music_app.core.csv.RuntimePermissionModel
import com.reaksmeyarun.music_app.core.csv.notificationPermission
import com.reaksmeyarun.music_app.core.csv.readMediaAudioPermission
import kotlinx.parcelize.Parcelize

@Parcelize
data class PermissionState(
    val notification: RuntimePermissionModel = RuntimePermissionModel(permission = notificationPermission),
    val readMedia: RuntimePermissionModel = RuntimePermissionModel(permission = readMediaAudioPermission)
) : Parcelable