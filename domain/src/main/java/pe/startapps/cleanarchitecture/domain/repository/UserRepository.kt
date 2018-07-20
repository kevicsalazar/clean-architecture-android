package pe.startapps.cleanarchitecture.domain.repository

import io.reactivex.Single
import pe.startapps.cleanarchitecture.domain.entities.User

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
interface UserRepository {

    fun getUserList(): Single<List<User>>

}