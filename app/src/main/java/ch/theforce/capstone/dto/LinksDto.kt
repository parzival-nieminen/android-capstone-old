package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LinksDto(
    val self: String,
    val html: String,
    val download: String,
    val download_location: String
) : Parcelable
