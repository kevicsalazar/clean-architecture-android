package pe.startapps.cleanarchitecture.presenters

import pe.startapps.cleanarchitecture.domain.usecases.GetProfileUseCase
import pe.startapps.cleanarchitecture.scopes.PerActivity
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerActivity
class MainPresenter @Inject constructor(private val view: View,
                                        private val getProfileUseCase: GetProfileUseCase) : BasePresenter {

    fun getProfile() {
        getProfileUseCase.getProfile()
        view.showMessage("OK")
    }

    override fun detachView() {

    }

    interface View {

        fun showMessage(message: String)

    }

}