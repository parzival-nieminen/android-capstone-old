package ch.theforce.capstone.network

import ch.theforce.capstone.BuildConfig
import ch.theforce.capstone.dto.ResponseDto
import ch.theforce.capstone.utils.LocalDateTimeDeserializer
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.time.LocalDateTime

/**
 * HTTP ktor client for the capstone app
 */
object UnSplashHttpClientImpl : UnSplashHttpClient {

    private val secureClient_: HttpClient
    private val publicClient_: HttpClient
    private const val baseUrl = BuildConfig.API_BASE_URL

    init {
        secureClient_ = initSecureClient()
        publicClient_ = initPublicClient()
    }

    override val secureClient: HttpClient
        get() = secureClient_
    override val publicClient: HttpClient
        get() = publicClient_

    /**
     * HTTP GET one RandomImage data from the api
     */
    override suspend fun getRandomImage(): ResponseDto {
        val responseDto = secureClient.get<ResponseDto>("$baseUrl/photos/random")
        secureClient.close()
        return responseDto
    }

    /**
     * Configuration for HTTP client
     */
    private fun initSecureClient() = HttpClient(CIO) {
        defaultRequest {
            header(HttpHeaders.Accept, BuildConfig.API_VERSION)
            header(HttpHeaders.Authorization, BuildConfig.API_CLIENT_ID)
        }
        install(JsonFeature) {
            serializer = GsonSerializer() {
                setPrettyPrinting()
                registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer)
            }
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
        CurlUserAgent()
    }

    private fun initPublicClient() = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer() {
                setPrettyPrinting()
                registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer)
            }
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
        CurlUserAgent()
    }
}
