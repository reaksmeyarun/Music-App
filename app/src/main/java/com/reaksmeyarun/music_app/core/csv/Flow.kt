package com.reaksmeyarun.music_app.core.csv

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Composable
fun <T> ObserveEvent(flow: Flow<T>, onEvent: suspend (T) -> Unit) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(flow, lifecycleOwner.lifecycle) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            /** Note:
            - Channel/SharedFlow can lead it to bug because channel, shareFlow is not guaranty collect when any configuration change of UI
            It mean is can be lose while Channel/SharedFlow send/emit in background thread
             * By fixing this issues:
            - Wrap flow.collect inside withContext(Dispatchers.Main.immediate)
            - Dispatchers.Main.immediate allow flow collect before any configuration change of UI
             */
            withContext(Dispatchers.Main.immediate) {
                flow.collect(onEvent)
            }
        }
    }
}