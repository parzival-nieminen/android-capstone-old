package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileImageDto(
    val small: String?,
    val medium: String?,
    val large: String?,
) : Parcelable
