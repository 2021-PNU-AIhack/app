package org.techtown.tour

import com.google.gson.annotations.SerializedName

data class HTTP_GET_Model(
    var something : String? =null ,
    var users : ArrayList<UserModel>? =null
)


data class UserModel(
    var idx : Int? =null ,
    var id : String?=null,
    var nick : String? =null
)


data class PostModel(
    var id : String? =null ,
    var pwd : String?=null,
    var nick : String? =null
)

data class PostResult(
    var result:String? = null
)

//data class SpotArr(
//    var array: List<DataModels>
//)

class DataModels{

    @SerializedName("pred_spots")
    lateinit var pred_spots : String

    @SerializedName("pred_ratings")
    lateinit var pred_ratings : String

    fun getspots(): String {
        return pred_spots
    }
    fun getratings(): String {
        return pred_ratings
    }

}