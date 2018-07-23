package pe.startapps.cleanarchitecture.data.mappers

import pe.startapps.cleanarchitecture.data.entities.PetEntity
import pe.startapps.cleanarchitecture.domain.entities.Pet

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
object PetMapper {

    fun transformPetEntity(entity: PetEntity) = Pet(
            id = entity.id,
            name = entity.name,
            phrase = entity.phrase,
            imageUrl = entity.imageUrl,
            description = entity.description
    )

    fun transformPetEntityList(list: List<PetEntity>) = list.map { transformPetEntity(it) }

}