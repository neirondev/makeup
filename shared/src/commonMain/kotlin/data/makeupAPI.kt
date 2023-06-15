package data


import data.model.MakeUpItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

public const val BASE_URL ="http://makeup-api.herokuapp.com/api/v1/"
public const val RESPONSE_FORMAT = ".json"
@ThreadLocal
public object MakeUPAPI {
    private val nonStrictJson = Json {isLenient = true; ignoreUnknownKeys = true}
    private val client: HttpClient = HttpClient {
       /* defaultRequest {
            header("X-App-Name", "learn")
        }*/
        /*install(ContentNegotiation) {
            json(nonStrictJson)
        }*/
        install(Logging) {
        logger = HttpClientLogger
        level = LogLevel.ALL
    }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
               // useAlternativeNames = false
            })
        }

    }

  suspend fun fetchMakeUPData(feedUrl: String): List<MakeUpItem> =
        client.get("$BASE_URL$feedUrl").body()
}