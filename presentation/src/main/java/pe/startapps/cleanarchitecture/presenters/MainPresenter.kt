package pe.startapps.cleanarchitecture.presenters

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import pe.startapps.cleanarchitecture.domain.usecases.UsersListUseCase
import pe.startapps.cleanarchitecture.mappers.UserMapper
import pe.startapps.cleanarchitecture.scopes.PerActivity
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerActivity
class MainPresenter @Inject constructor(private val view: View,
                                        private val usersListUseCase: UsersListUseCase) : BasePresenter {

    private val cd = CompositeDisposable()

    fun getUserList() {
        cd += usersListUseCase.execute()
                .map { UserMapper.transformUserList(it) }
                .subscribe({
                    println(it.toString())
                    view.showMessage("OK")
                }, {
                    view.showMessage(it.localizedMessage)
                })
    }

    override fun detachView() {
        cd.clear()
    }

    interface View {

        fun showMessage(message: String)

    }

}