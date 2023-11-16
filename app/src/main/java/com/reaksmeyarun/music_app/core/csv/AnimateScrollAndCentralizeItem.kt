package com.reaksmeyarun.music_app.core.csv

import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.lazy.LazyListState

suspend fun LazyListState.animateCentralizeItem(index: Int) {
    val itemInfo = layoutInfo.visibleItemsInfo.firstOrNull { it.index == index }
    if (itemInfo != null) {
        val center = layoutInfo.viewportEndOffset / 2
        val childCenter = itemInfo.offset + itemInfo.size / 2
        animateScrollBy((childCenter - center).toFloat())
    } else
        animateScrollToItem(index)
}