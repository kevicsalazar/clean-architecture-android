package pe.startapps.cleanarchitecture.domain

import io.reactivex.Scheduler

/**
 * Created by kevinsalazar.
 */
interface SchedulersProvider {

    fun io(): Scheduler

    fun trampoline(): Scheduler

    fun computation(): Scheduler

    fun ui(): Scheduler

}