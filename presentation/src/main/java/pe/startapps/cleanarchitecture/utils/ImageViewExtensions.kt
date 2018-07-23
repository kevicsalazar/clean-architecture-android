package pe.startapps.cleanarchitecture.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun ImageView.load(url: String?) {
    Picasso.get().load(url).into(this)
}