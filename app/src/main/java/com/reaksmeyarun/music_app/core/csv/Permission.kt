package com.reaksmeyarun.music_app.core.csv

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
const val notificationPermission = Manifest.permission.POST_NOTIFICATIONS

val readMediaAudioPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
    Manifest.permission.READ_MEDIA_AUDIO
else
    Manifest.permission.READ_EXTERNAL_STORAGE