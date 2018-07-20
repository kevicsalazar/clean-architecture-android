package pe.startapps.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by kevinsalazar.
 */
class ResponseEntity<T> {

    @SerializedName("data")
    var data: T? = null

}