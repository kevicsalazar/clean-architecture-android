package pe.startapps.cleanarchitecture.modules

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pe.startapps.cleanarchitecture.activities.MainActivity
import pe.startapps.cleanarchitecture.fragments.HomeFragment
import pe.startapps.cleanarchitecture.scopes.PerActivity
import pe.startapps.cleanarchitecture.scopes.PerFragment
import pe.startapps.cleanarchitecture.views.MainView

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun bindMainView(activity: MainActivity): MainView

    @PerFragment
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

}