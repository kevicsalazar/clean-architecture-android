package pe.startapps.cleanarchitecture.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_pet.view.*
import pe.startapps.cleanarchitecture.R
import pe.startapps.cleanarchitecture.models.PetModel
import pe.startapps.cleanarchitecture.utils.load

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class PetRecyclerAdapter(val items: List<PetModel>) : RecyclerView.Adapter<PetRecyclerAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(pet: PetModel) {
            itemView.tvName.text = pet.name
            itemView.tvPhrase.text = pet.phrase
            itemView.ivPet.load(pet.imageUrl)
            itemView.tvDescription.text = pet.description
        }

    }

}