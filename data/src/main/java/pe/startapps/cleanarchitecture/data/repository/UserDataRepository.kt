package pe.startapps.cleanarchitecture.data.repository

import io.reactivex.Single
import pe.startapps.cleanarchitecture.data.mappers.UserMapper
import pe.startapps.cleanarchitecture.data.sources.cloud.UserService
import pe.startapps.cleanarchitecture.data.utils.handleError
import pe.startapps.cleanarchitecture.domain.entities.User
import pe.startapps.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Singleton
class UserDataRepository @Inject constructor(private val userService: UserService) : UserRepository {

    override fun getUserProfile(): Single<User> {
        return userService.getProfile().handleError()
                .map { UserMapper.transformUserEntity(it.data!!) }
    }

}