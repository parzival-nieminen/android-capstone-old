package ch.theforce.capstone.network

import ch.theforce.capstone.dto.PhotoDto
import ch.theforce.capstone.dto.TopicDto
import io.ktor.client.*

interface UnSplashHttpClient {
    val secureClient: HttpClient
    val publicClient: HttpClient

    suspend fun getRandomPhoto(): PhotoDto
    suspend fun getFeaturedTopics(): List<TopicDto>
    fun closeClients()
}
