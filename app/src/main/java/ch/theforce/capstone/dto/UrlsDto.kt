package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UrlsDto(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
) : Parcelable
