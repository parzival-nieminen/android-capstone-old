package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PositionDto(
    val latitude: Float?,
    val longitude: Float?
) : Parcelable
