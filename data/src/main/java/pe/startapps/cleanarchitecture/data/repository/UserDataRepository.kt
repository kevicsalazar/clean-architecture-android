package pe.startapps.cleanarchitecture.data.repository

import io.reactivex.Single
import pe.startapps.cleanarchitecture.data.utils.handleError
import pe.startapps.cleanarchitecture.data.mappers.UserMapper
import pe.startapps.cleanarchitecture.data.sources.cloud.ApiService
import pe.startapps.cleanarchitecture.domain.entities.User
import pe.startapps.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class UserDataRepository @Inject constructor(private val apiService: ApiService) : UserRepository {

    override fun getUserList(): Single<List<User>> {
        return apiService.getUserList().handleError()
                .map { UserMapper.transformUserEntityList(it.data!!) }
    }

}