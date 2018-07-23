package pe.startapps.cleanarchitecture.domain.repository

import io.reactivex.Single
import pe.startapps.cleanarchitecture.domain.entities.Pet

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface PetRepository {

    fun getPetList(): Single<List<Pet>>

}