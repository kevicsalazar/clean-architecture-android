package pe.startapps.cleanarchitecture.mappers

import pe.startapps.cleanarchitecture.domain.entities.Pet
import pe.startapps.cleanarchitecture.models.PetModel

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
object PetMapper {

    fun transformPet(entity: Pet) = PetModel(
            id = entity.id,
            name = entity.name,
            phrase = entity.phrase,
            imageUrl = entity.imageUrl,
            description = entity.description
    )

    fun transformPetList(list: List<Pet>) = list.map { transformPet(it) }

}