package ch.theforce.capstone.network

import ch.theforce.capstone.dto.ResponseDto
import io.ktor.client.*

interface UnSplashHttpClient {
    val secureClient: HttpClient
    val publicClient: HttpClient

    suspend fun getRandomImage(): ResponseDto
}
