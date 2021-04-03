package ch.theforce.capstone.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
data class TopicDto(
    val id: String,
    val slug: String,
    val title: String,
    val description: String,
    val published_at: LocalDateTime,
    val featured: Boolean,
    val total_photos: Int,
    val links: TopicLinkDto,
    val status: String,
    val owners: UserDto,
    val cover_photo: PhotoDto,
    val preview_photo: PreviewPhotoDto
) : Parcelable
