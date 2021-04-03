package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
data class PreviewPhotoDto(
    val id: String,
    val created_at: LocalDateTime,
    val updated_at: LocalDateTime,
    val blur_hash: String,
    val urls: UrlsDto
) : Parcelable
