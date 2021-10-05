//package org.techtown.tour;
//
//import java.lang.reflect.Array;
//
//import retrofit2.Call;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.Headers;
//import retrofit2.http.POST;
//
//public interface RetrofitNetwork {
//    @POST("/users")
//    @Headers("accept: application/json",
//            "content-type: application/json")
//    fun post_users(
//            @Body jsonparams: PostModel
//    ): Call<PostResult>
//
//    @GET("/users")
//    @Headers("accept: application/json",
//            "content-type: application/json"
//    )
//    fun get_users(
//    ): Call<HTTP_GET_Model>
//
//
//    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
//        private const val BASE_URL = "http://234.234.234.33:7712" // 주소
//
//        fun create(): APIS {
//
//
//            val gson :Gson =   GsonBuilder().setLenient().create();
//
//            return Retrofit.Builder()
//                    .baseUrl(BASE_URL)
////                .client(client)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .build()
//                    .create(RetrofitNetwork::class.java)
//        }
//    }
//
//    class fun {
//    }
//}

