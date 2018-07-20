package pe.startapps.cleanarchitecture.data.sources

import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.POST

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface ApiService {

    @POST("/patient/profile")
    fun getProfile(): Single<JsonObject>

}