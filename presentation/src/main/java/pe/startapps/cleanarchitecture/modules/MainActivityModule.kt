package pe.startapps.cleanarchitecture.modules

import dagger.Binds
import dagger.Module
import pe.startapps.cleanarchitecture.activities.MainActivity
import pe.startapps.cleanarchitecture.scopes.PerActivity
import pe.startapps.cleanarchitecture.views.MainView

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun provideMainView(activity: MainActivity): MainView

}