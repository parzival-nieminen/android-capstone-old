package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
data class UserDto(
    val id: String,
    val updated_at: LocalDateTime,
    val username: String,
    val name: String,
    val first_name: String,
    val last_name: String,
    val twitter_username: String?,
    val portfolio_url: String?,
    val bio: String?,
    val location: String?,
    val links: UserLinksDto?,
    val profile_image: ProfileImageDto?,
    val instagram_username: String?,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val accepted_tos: Boolean,
    val for_hire: Boolean
) : Parcelable
