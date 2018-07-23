package pe.startapps.cleanarchitecture.presenters

import io.reactivex.disposables.CompositeDisposable
import pe.startapps.cleanarchitecture.scopes.PerActivity
import pe.startapps.cleanarchitecture.views.MainView
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerActivity
class MainPresenter @Inject constructor(private val view: MainView) : BasePresenter {

    private val cd = CompositeDisposable()

    override fun detachView() {
        cd.clear()
    }

}