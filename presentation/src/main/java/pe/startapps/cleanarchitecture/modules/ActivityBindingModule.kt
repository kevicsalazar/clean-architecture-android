package pe.startapps.cleanarchitecture.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pe.startapps.cleanarchitecture.activities.MainActivity
import pe.startapps.cleanarchitecture.scopes.PerActivity

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

}