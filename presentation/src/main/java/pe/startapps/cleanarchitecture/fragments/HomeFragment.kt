package pe.startapps.cleanarchitecture.fragments

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.*
import pe.startapps.cleanarchitecture.R
import pe.startapps.cleanarchitecture.adapters.PetRecyclerAdapter
import pe.startapps.cleanarchitecture.models.PetModel
import pe.startapps.cleanarchitecture.presenters.BasePresenter
import pe.startapps.cleanarchitecture.presenters.HomePresenter
import pe.startapps.cleanarchitecture.utils.CountDrawable
import pe.startapps.cleanarchitecture.views.HomeView
import pe.startapps.cleanarchitecture.views.MainView
import javax.inject.Inject


/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class HomeFragment : BaseFragment(), HomeView {

    @Inject
    lateinit var homePresenter: HomePresenter

    private val mainView by lazy { activity as? MainView }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        homePresenter.getPetList()
    }

    override val layout: Int get() = R.layout.fragment_home

    override val presenter: BasePresenter? get() = homePresenter

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        setCount(menu, "1")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> mainView?.toggleMenu()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showPetList(petList: List<PetModel>) {
        val adapter = PetRecyclerAdapter(petList)
        recyclerView.adapter = adapter
    }

    override fun showMessage(message: String) {

    }

    private fun setCount(menu: Menu, count: String) {

        val menuItem = menu.findItem(R.id.action_notification)
        val icon = menuItem.icon as LayerDrawable

        val reuse = icon.findDrawableByLayerId(R.id.ic_notification_count)
        val badge = (reuse as? CountDrawable) ?: CountDrawable(context)

        badge.setCount(count)
        icon.mutate()
        icon.setDrawableByLayerId(R.id.ic_notification_count, badge)

    }

}