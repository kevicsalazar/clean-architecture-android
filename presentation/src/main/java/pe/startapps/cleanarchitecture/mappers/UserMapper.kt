package pe.startapps.cleanarchitecture.mappers

import pe.startapps.cleanarchitecture.domain.entities.User
import pe.startapps.cleanarchitecture.models.UserModel

/**
 * Created by kevinsalazar.
 */
object UserMapper {

    fun transformUser(user: User) = UserModel(
            fullname = "${user.name} ${user.lastname}"
    )

    fun transformUserList(list: List<User>) = list.map { transformUser(it) }

}