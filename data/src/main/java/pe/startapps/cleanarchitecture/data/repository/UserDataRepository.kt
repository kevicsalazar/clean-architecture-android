package pe.startapps.cleanarchitecture.data.repository

import pe.startapps.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class UserDataRepository @Inject constructor() : UserRepository {

    override fun getProfile() {
        println("repo -> " + hashCode())
    }

}