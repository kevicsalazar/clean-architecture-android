package pe.startapps.cleanarchitecture.views

import pe.startapps.cleanarchitecture.models.PetModel

/**
 * Created by kevinsalazar.
 */
interface HomeView {

    fun showPetList(petList: List<PetModel>)

    fun showMessage(message: String)

}