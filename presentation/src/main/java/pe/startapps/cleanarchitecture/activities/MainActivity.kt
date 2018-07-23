package pe.startapps.cleanarchitecture.activities

import android.os.Bundle
import android.support.v4.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import pe.startapps.cleanarchitecture.R
import pe.startapps.cleanarchitecture.fragments.HomeFragment
import pe.startapps.cleanarchitecture.presenters.BasePresenter
import pe.startapps.cleanarchitecture.presenters.MainPresenter
import pe.startapps.cleanarchitecture.utils.replaceContentFragment
import pe.startapps.cleanarchitecture.views.MainView
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceContentFragment(R.id.container, HomeFragment())
    }

    override val layout: Int get() = R.layout.activity_main

    override val presenter: BasePresenter? get() = mainPresenter

    override fun toggleMenu() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun showMessage(message: String) {

    }

}
