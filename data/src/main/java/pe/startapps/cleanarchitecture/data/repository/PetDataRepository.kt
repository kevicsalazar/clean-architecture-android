package pe.startapps.cleanarchitecture.data.repository

import io.reactivex.Single
import pe.startapps.cleanarchitecture.data.mappers.PetMapper
import pe.startapps.cleanarchitecture.data.sources.cloud.PetService
import pe.startapps.cleanarchitecture.data.utils.handleError
import pe.startapps.cleanarchitecture.domain.entities.Pet
import pe.startapps.cleanarchitecture.domain.repository.PetRepository
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class PetDataRepository @Inject constructor(private val petService: PetService) : PetRepository {

    override fun getPetList(): Single<List<Pet>> {
        return petService.getPetList().handleError()
                .map { PetMapper.transformPetEntityList(it.data!!) }
    }

}