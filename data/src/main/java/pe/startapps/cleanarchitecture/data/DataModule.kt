package pe.startapps.cleanarchitecture.data

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import pe.startapps.cleanarchitecture.data.modules.RepositoryModule
import pe.startapps.cleanarchitecture.data.modules.SourcesModule
import javax.inject.Singleton

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module(includes = [
    SourcesModule::class,
    RepositoryModule::class
])
class DataModule {

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().apply {
        setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }.create()!!

}