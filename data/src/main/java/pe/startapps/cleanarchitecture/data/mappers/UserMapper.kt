package pe.startapps.cleanarchitecture.data.mappers

import pe.startapps.cleanarchitecture.data.entities.UserEntity
import pe.startapps.cleanarchitecture.domain.entities.User

/**
 * Created by kevinsalazar.
 */
object UserMapper {

    fun transformUserEntity(entity: UserEntity) = User(
            id = entity.id,
            name = entity.name,
            lastname = entity.lastname
    )

    fun transformUserEntityList(list: List<UserEntity>) = list.map { transformUserEntity(it) }

}