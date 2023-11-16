package com.reaksmeyarun.music_app.core.data.local.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(
//    name = "${BuildConfig.APPLICATION_ID}.user.dataStore"
    name = "user.dataStore"
)