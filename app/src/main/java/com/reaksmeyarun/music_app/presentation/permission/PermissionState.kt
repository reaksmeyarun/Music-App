package com.reaksmeyarun.music_app.presentation.permission

import android.os.Parcelable
import com.reaksmeyarun.music_app.core.csv.RuntimePermissionModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PermissionState(
    val notification: RuntimePermissionModel = RuntimePermissionModel(),
    val readStorage: RuntimePermissionModel = RuntimePermissionModel()
) : Parcelable