package pe.startapps.cleanarchitecture.presenters

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import pe.startapps.cleanarchitecture.domain.usecases.PetListUseCase
import pe.startapps.cleanarchitecture.mappers.PetMapper
import pe.startapps.cleanarchitecture.scopes.PerFragment
import pe.startapps.cleanarchitecture.views.HomeView
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerFragment
class HomePresenter @Inject constructor(private val view: HomeView,
                                        private val petListUseCase: PetListUseCase) : BasePresenter {

    private val cd = CompositeDisposable()

    fun getPetList() {
        cd += petListUseCase.execute()
                .map { PetMapper.transformPetList(it) }
                .subscribe({
                    view.showPetList(it)
                }, {
                    view.showMessage(it.localizedMessage)
                })
    }

    override fun detachView() {
        cd.clear()
    }

}