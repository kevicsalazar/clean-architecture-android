package pe.startapps.cleanarchitecture.data.utils

import com.google.gson.JsonParser
import io.reactivex.Single
import pe.startapps.cleanarchitecture.data.entities.ResponseEntity
import pe.startapps.cleanarchitecture.domain.exceptions.NetworkException
import pe.startapps.cleanarchitecture.domain.exceptions.UnauthorizedException
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by kevinsalazar.
 */


fun <T> Single<ResponseEntity<T>>.handleError(): Single<ResponseEntity<T>> {
    return onErrorResumeNext { Single.error(it.transform()) }
}

fun Throwable.transform() = when (this) {
    is IOException   -> NetworkException()
    is HttpException -> {
        val message = parseBody()
        when (code()) {
            401  -> UnauthorizedException(message)
            else -> Exception()
        }
    }
    else             -> Exception()
}

fun HttpException.parseBody(): String {
    val body = response().errorBody()?.string()
    val json = JsonParser().parse(body)
    return json.asJsonObject["content"].asString
}