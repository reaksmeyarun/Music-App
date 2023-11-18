package com.reaksmeyarun.music_app.core.csv

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

fun Context.checkPermissionStatus(permission: String): EPermissionStatus {
    val isPermissionGranted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    val status: EPermissionStatus = if (isPermissionGranted)
        EPermissionStatus.PermissionGrant
    else {
        val shouldShowRationale = ActivityCompat.shouldShowRequestPermissionRationale(this as ComponentActivity, permission)
        if (shouldShowRationale)
            EPermissionStatus.PermissionDenied
        else
            EPermissionStatus.PermissionNoGrant
    }
    return status
}

fun Context.requestPermission(permissions: String) =
    ActivityCompat.requestPermissions(
        /* activity = */ this as Activity,
        /* permissions = */ arrayOf(permissions),
        /* requestCode = */ Random.nextInt(1, 100)
    )

fun Context.requestPermissions(permissions: Array<String>) =
    ActivityCompat.requestPermissions(
        /* activity = */ this as Activity,
        /* permissions = */ permissions,
        /* requestCode = */ Random.nextInt(1, 100)
    )

enum class EPermissionStatus(val message: String) {
    PermissionDenied("Permission Denied!"),
    PermissionGrant("Permission Granted!"),
    PermissionNoGrant("Permission Not Granted!"),
}

@Parcelize
data class RuntimePermissionModel(
    var permission: String? = null,
    var isRationale: Boolean = false,
    var status: EPermissionStatus = EPermissionStatus.PermissionNoGrant
) : Parcelable {

    fun isPermissionDenied() = status == EPermissionStatus.PermissionDenied
    fun isPermissionNoGrant() = status == EPermissionStatus.PermissionNoGrant
    fun isPermissionGrant() = status == EPermissionStatus.PermissionGrant

}