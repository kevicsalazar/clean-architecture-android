package pe.startapps.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
data class PetEntity(@SerializedName("_id") val id: String = "",
                     @SerializedName("name") val name: String = "",
                     @SerializedName("phrase") val phrase: String = "",
                     @SerializedName("image_url") val imageUrl: String = "",
                     @SerializedName("description") val description: String = "")