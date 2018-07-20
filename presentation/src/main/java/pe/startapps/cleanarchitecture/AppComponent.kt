package pe.startapps.cleanarchitecture

import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}