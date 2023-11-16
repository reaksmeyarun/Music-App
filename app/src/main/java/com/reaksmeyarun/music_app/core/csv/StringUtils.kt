package com.reaksmeyarun.music_app.core.csv

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.reaksmeyarun.music_app.R

internal fun specificBold(originalValue: String, value: String) = buildAnnotatedString {
    append(originalValue.substringBefore(value))
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
        append(value)
    }
    append(originalValue.substringAfter(value))
}

@Composable
internal fun permissionNoteDescription() = buildAnnotatedString {
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
        append(stringResource(R.string.notification_permission))
    }
    append(stringResource(R.string.allows))
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
        append(stringResource(R.string.music_app))
    }
    append(stringResource(R.string.to_create_and_manage_notifications_on_the_device_it_is_not_required_specifically_for_accessing_or_working_with_mp3_files))
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
        append(stringResource(R.string.storage_permission))
    }
    append(stringResource(R.string.allows))
    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
        append(stringResource(R.string.music_app))
    }
    append(stringResource(R.string.to_access_mp3_files_because_it_grants_your_app_the_ability_to_read_user_data_stored_in_the_device_s_external_storage))
}