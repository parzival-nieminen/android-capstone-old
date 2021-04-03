package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationDto(
    val title: String?,
    val name: String?,
    val city: String?,
    val country: String?,
    val position: PositionDto?
) : Parcelable
