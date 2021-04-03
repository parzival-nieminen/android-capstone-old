package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
data class PhotoDto(
    val id: String,
    val created_at: LocalDateTime,
    val updated_at: LocalDateTime,
    val promoted_at: LocalDateTime?,
    val width: Int,
    val height: Int,
    val color: String,
    val blur_hash: String,
    val description: String?,
    val alt_description: String?,
    val urls: UrlsDto,
    val links: LinksDto,
    val categories: List<String>?,
    val likes: Int,
    val liked_by_user: Boolean,
    val current_user_collections: List<String>?,
    val sponsorship: String?,
    val user: UserDto,
    val exif: ExifDto?,
    val location: LocationDto?,
    val views: Int,
    val downloads: Int
) : Parcelable
