package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopicLinkDto(
    val self: String,
    val html: String,
    val photos: String
) : Parcelable
