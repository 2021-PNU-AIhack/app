package org.techtown.tour

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIS {

//    @POST("/users")
//    @Headers("accept: application/json",
//        "content-type: application/json")
//    fun post_users(
//        @Body jsonparams: PostModel
//    ): Call<PostResult>
//
//    @GET("/users")
//    @Headers("accept: application/json",
//        "content-type: application/json"
//    )
//    fun get_users(
//    ): Call<HTTP_GET_Model>
//
//    @POST("/users")
//    @Headers("accept: application/json",
//        "content-type: application/json")
//    fun get_recom(
//    ): Call


    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
        private const val BASE_URL = "https://pnu-ai-hackathon-dbccqsd3hq-uc.a.run.app/predict?spot_i=광안리해수욕장&rating_i=3&spot_j=감천문화마을&rating_j=4&spot_k=청사포&rating_k=3" // 주소

        fun create(): APIS {


            val gson : Gson =   GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIS::class.java)
        }
    }
}