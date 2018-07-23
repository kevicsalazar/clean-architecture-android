package pe.startapps.cleanarchitecture.domain.usecases

import io.reactivex.Single
import pe.startapps.cleanarchitecture.domain.SchedulersProvider
import pe.startapps.cleanarchitecture.domain.entities.Pet
import pe.startapps.cleanarchitecture.domain.repository.PetRepository
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class PetListUseCase @Inject constructor(private val petRepository: PetRepository,
                                         private val schedulers: SchedulersProvider) {

    fun execute(): Single<List<Pet>> {
        return petRepository.getPetList()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }

}