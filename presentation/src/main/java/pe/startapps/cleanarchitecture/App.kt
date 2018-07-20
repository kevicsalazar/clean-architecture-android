package pe.startapps.cleanarchitecture

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    init {
        DaggerAppComponent.builder()
                .create(this)
                .inject(this)
    }

    override fun activityInjector() = activityInjector

}