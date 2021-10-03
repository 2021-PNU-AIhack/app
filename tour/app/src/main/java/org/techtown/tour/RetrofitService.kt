package org.techtown.tour

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    //Request URL : http://api.teamcarelab.com:18393/api/player?name=morris
    @GET("predict")  //@GET 뒤에 기본 URL 뒤에 들어갈 경로가 들어간다.
    fun requestList(
        @Query("spot_i") spot_i: String,  // @Query안에 ? 뒤에 들어갈 변수가 들어간다.
        @Query("rating_i") rating_i: Int,
        @Query("spot_j") spot_j: String,
        @Query("rating_j") rating_j: Int,
        @Query("spot_k") spot_k: String,
        @Query("rating_k") rating_k: Int
    ) : Call<SpotArr>
}