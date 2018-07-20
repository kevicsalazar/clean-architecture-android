package pe.startapps.cleanarchitecture

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import pe.startapps.cleanarchitecture.data.DataModule
import pe.startapps.cleanarchitecture.modules.ActivityBindingModule

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module(
        includes = [
            DataModule::class,
            ActivityBindingModule::class,
            AndroidSupportInjectionModule::class
        ]
)
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app

}