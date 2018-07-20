package pe.startapps.cleanarchitecture.data.modules

import dagger.Binds
import dagger.Module
import pe.startapps.cleanarchitecture.data.repository.UserDataRepository
import pe.startapps.cleanarchitecture.domain.repository.UserRepository

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(rep: UserDataRepository): UserRepository

}