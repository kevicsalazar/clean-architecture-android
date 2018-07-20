package pe.startapps.cleanarchitecture.modules

import dagger.Binds
import dagger.Module
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pe.startapps.cleanarchitecture.domain.SchedulersProvider
import javax.inject.Inject

/**
 * Created by kevinsalazar.
 */
@Module
abstract class SchedulersModule {

    @Binds
    abstract fun bindSchedulerProvider(schedulersProvider: SchedulersProviderImpl): SchedulersProvider

    class SchedulersProviderImpl @Inject constructor() : SchedulersProvider {

        override fun io() = Schedulers.io()

        override fun trampoline() = Schedulers.trampoline()

        override fun computation() = Schedulers.computation()

        override fun ui() = AndroidSchedulers.mainThread()!!

    }

}