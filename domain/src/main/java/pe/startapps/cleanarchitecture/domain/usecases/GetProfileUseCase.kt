package pe.startapps.cleanarchitecture.domain.usecases

import pe.startapps.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject


/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class GetProfileUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun getProfile() {
        userRepository.getProfile()
    }

}