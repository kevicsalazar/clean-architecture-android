package pe.startapps.cleanarchitecture.data.sources.cloud

import io.reactivex.Single
import pe.startapps.cleanarchitecture.data.entities.ResponseEntity
import pe.startapps.cleanarchitecture.data.entities.UserEntity
import retrofit2.http.GET

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface ApiService {

    @GET("/api/users")
    fun getUserList(): Single<ResponseEntity<List<UserEntity>>>

}