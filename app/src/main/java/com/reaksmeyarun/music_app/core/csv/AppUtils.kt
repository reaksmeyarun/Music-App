package com.reaksmeyarun.music_app.core.csv

import android.content.Intent
import android.net.Uri
import android.provider.Settings

fun openAppSettings(context: android.content.Context) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri: Uri = Uri.fromParts("package", context.packageName, null)
    intent.data = uri
    context.startActivity(intent)
}