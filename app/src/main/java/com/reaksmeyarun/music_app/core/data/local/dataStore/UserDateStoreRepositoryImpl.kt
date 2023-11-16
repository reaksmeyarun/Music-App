package com.reaksmeyarun.music_app.core.data.local.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.reaksmeyarun.music_app.core.domain.repository.local.UserDateStoreRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserDateStoreRepositoryImpl(
    private val userDataStorePreferences: DataStore<Preferences>
) : UserDateStoreRepository {

    private companion object {
        val keyName = stringPreferencesKey("name")
    }

    override suspend fun setName(name: String) {
        Result.runCatching {
            userDataStorePreferences.edit { preferences ->
                preferences[keyName] = name
            }
        }
    }

    override suspend fun getName() = Result.runCatching {
        val data = userDataStorePreferences.data.catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[keyName]
            }
        data.firstOrNull() ?: ""
    }
}
