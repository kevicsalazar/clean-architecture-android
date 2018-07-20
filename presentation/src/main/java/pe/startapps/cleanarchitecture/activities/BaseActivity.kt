package pe.startapps.cleanarchitecture.activities

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import pe.startapps.cleanarchitecture.presenters.BasePresenter

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

    protected abstract val layout: Int

    protected abstract val presenter: BasePresenter?

}