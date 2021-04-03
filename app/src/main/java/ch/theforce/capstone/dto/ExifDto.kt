package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExifDto(
    val make: String,
    val model: String,
    val exposure_time: String,
    val aperture: String,
    val focal_length: String,
    val iso: String
) : Parcelable
