package org.techtown.tour

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

data class SpotArr(
    var array: List<DataModels>
)

data class DataModels(
    var pred_spots : String,
    var pred_ratings : Int
)


