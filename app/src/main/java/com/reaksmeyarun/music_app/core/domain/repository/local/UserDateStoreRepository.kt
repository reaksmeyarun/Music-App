package com.reaksmeyarun.music_app.core.domain.repository.local

interface UserDateStoreRepository {
    suspend fun setName(name: String)
    suspend fun getName() : Result<String>
}