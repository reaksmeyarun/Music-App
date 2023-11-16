package com.reaksmeyarun.music_app.presentation.permission

import com.reaksmeyarun.music_app.core.csv.EPermissionStatus

sealed class PermissionEvent {

    data class CheckNotificationPermission(val status: EPermissionStatus) : PermissionEvent()

    data class CheckReadStoragePermission(val status: EPermissionStatus) : PermissionEvent()

    object RequestNotificationPermission : PermissionEvent()

    object RequestReadStoragePermission : PermissionEvent()

    object DismissRationaleDialog : PermissionEvent()

    object GoToSetting : PermissionEvent()

}