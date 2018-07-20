package pe.startapps.cleanarchitecture.activities

import android.os.Bundle
import pe.startapps.cleanarchitecture.R
import pe.startapps.cleanarchitecture.presenters.BasePresenter
import pe.startapps.cleanarchitecture.presenters.MainPresenter
import pe.startapps.cleanarchitecture.views.MainView
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Presenter: ${mainPresenter.hashCode()}")

        mainPresenter.getUserList()

    }

    override val layout: Int get() = R.layout.activity_main

    override val presenter: BasePresenter? get() = mainPresenter

    override fun showMessage(message: String) {
        println(message)
    }

}
