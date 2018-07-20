package pe.startapps.cleanarchitecture.domain.usecases

import io.reactivex.Single
import pe.startapps.cleanarchitecture.domain.SchedulersProvider
import pe.startapps.cleanarchitecture.domain.entities.User
import pe.startapps.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject


/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class UsersListUseCase @Inject constructor(private val userRepository: UserRepository,
                                           private val schedulers: SchedulersProvider) {

    fun execute(): Single<List<User>> {
        return userRepository.getUserList()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }

}