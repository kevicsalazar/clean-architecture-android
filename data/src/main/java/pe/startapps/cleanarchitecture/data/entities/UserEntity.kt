package pe.startapps.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by kevinsalazar.
 */
data class UserEntity(
        @SerializedName("_id") val id: String = "",
        @SerializedName("first_name") val name: String = "",
        @SerializedName("last_name") val lastname: String = "")