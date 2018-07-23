package pe.startapps.cleanarchitecture.modules

import dagger.Binds
import dagger.Module
import pe.startapps.cleanarchitecture.fragments.HomeFragment
import pe.startapps.cleanarchitecture.scopes.PerFragment
import pe.startapps.cleanarchitecture.views.HomeView

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class HomeFragmentModule {

    @Binds
    @PerFragment
    abstract fun bindHomeView(fragment: HomeFragment): HomeView

}