package pe.startapps.cleanarchitecture.activities

import android.os.Bundle
import pe.startapps.cleanarchitecture.R
import pe.startapps.cleanarchitecture.presenters.BasePresenter
import pe.startapps.cleanarchitecture.presenters.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainPresenter.View {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Presenter: ${mainPresenter.hashCode()}")

        mainPresenter.getProfile()

    }

    override val layout: Int get() = R.layout.activity_main

    override val presenter: BasePresenter? get() = mainPresenter

    override fun showMessage(message: String) {
        println(message)
    }

}
