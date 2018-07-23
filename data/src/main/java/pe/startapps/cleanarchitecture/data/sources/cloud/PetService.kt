package pe.startapps.cleanarchitecture.data.sources.cloud

import io.reactivex.Single
import pe.startapps.cleanarchitecture.data.entities.PetEntity
import pe.startapps.cleanarchitecture.data.entities.ResponseEntity
import retrofit2.http.GET

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface PetService {

    @GET("/api/pets")
    fun getPetList(): Single<ResponseEntity<List<PetEntity>>>

}