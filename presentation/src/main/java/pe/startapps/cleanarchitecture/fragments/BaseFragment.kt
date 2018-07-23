package pe.startapps.cleanarchitecture.fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import pe.startapps.cleanarchitecture.presenters.BasePresenter

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
abstract class BaseFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(layout, container!!, false)
    }

    protected abstract val layout: Int

    protected abstract val presenter: BasePresenter?

    protected fun setSupportActionBar(toolbar: Toolbar) {
        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)
    }

}