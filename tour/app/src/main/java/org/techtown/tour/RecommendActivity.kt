package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.ArrayList
import kotlin.concurrent.thread

class RecommendActivity : AppCompatActivity() {

    val displayList = ArrayList<TourData>()
    val spots = ArrayList<String>()
    val ratings = ArrayList<String>()

    val database = Firebase.database
    val myRef = database.getReference("user")
    val myRef2 = database.getReference("location")

    val nameArr = mapOf("용소웰빙공원" to 1,"몰운대 (부산 국가지질공원)" to 2,"일광해수욕장" to 3,"을숙도생태공원" to 4,"삼락생태공원" to 5,"대저생태공원" to 6,"흰여울문화마을" to 7,"감천문화마을" to 8,"구덕문화공원" to 9,"동래시장" to 10,"부산어촌민속관" to 11,"해운대시장" to 12,"조선통신사역사관" to 13,"아미산 전망대" to 14,"송도해수욕장" to 15,"태종대 (부산 국가지질공원)" to 16,"다대포해수욕장" to 17,"광안리해수욕장" to 18,"송정해수욕장" to 19,"오륙도 (부산 국가지질공원)" to 20,"암남공원" to 21,"청사포" to 22,"황령산 전망대" to 23,"가덕도 연대봉" to 24,"백양산 (부산 국가지질공원)" to 25,"성지곡수원지" to 26,"승학산" to 27,"아홉산숲" to 28,"일광해수욕장" to 29,"임랑해수욕장" to 30,"봉래산" to 31,"회동수원지" to 32,"부산시민공원" to 33,"용두산공원" to 34,"민락수변공원" to 35,"누리마루 APEC하우스" to 36,"어린이대공원" to 37,"금강공원" to 38,"대신공원" to 39,"수영사적공원" to 40,"화명생태공원" to 41,"우장춘기념관" to 42,"요산문학관" to 43,"수산과학관" to 44,"부산해양자연사박물관" to 45,"부산기상관측소" to 46)


    lateinit var spots1 : String
    lateinit var ratings1 : String
    lateinit var spots2 : String
    lateinit var ratings2 : String
    lateinit var spots3 : String
    lateinit var ratings3 : String

    lateinit var spot_name : String

    var str1 : String = ""
    var str2 : String = ""
    var str3 : String = ""

    //    val api = APIS.create();
    private lateinit var retrofit : Retrofit
    private lateinit var supplementService : RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

//        var testView1 = findViewById<TextView>(R.id.textView22)
//        var testView2 = findViewById<TextView>(R.id.textView33)
//        var testView3 = findViewById<TextView>(R.id.textView44)


        var getWhoCnt = intent.getIntExtra("whoCnt", 0)
        var getSeasonCnt = intent.getIntExtra("seasonCnt", 0)
        var getStyleCnt = intent.getIntExtra("styleCnt", 0)


        Log.d("checkkkwhocnt", getWhoCnt.toString())
        Log.d("checkkkseacnt", getSeasonCnt.toString())
        Log.d("checkkkstycnt", getStyleCnt.toString())

        if(getWhoCnt > 0) {
            for (i : Int in 0 until 6) {
                if (intent.getStringExtra("who$i") != null) {
                    str1 += intent.getStringExtra("who$i")
                    if (i < getWhoCnt-1) str1 += ", "
                    intent.getStringExtra("who$i")?.let { Log.d("checkkk", it) }
                }
            }
//            str1 += intent.getStringExtra("who${getWhoCnt-1}")
//            intent.getStringExtra("who${getWhoCnt-1}")?.let { Log.d("checkkk", it) }
        }

        if(getSeasonCnt > 0) {
            for (i : Int in 0 until 4) {
                if (intent.getStringExtra("season$i") != null) {
                    str2 += intent.getStringExtra("season$i")
                    if (i < getSeasonCnt-1) str2 += ", "
                    intent.getStringExtra("season$i")?.let { Log.d("checkkk", it) }
                }
            }
//            str2 += intent.getStringExtra("season${getSeasonCnt-1}")
//            intent.getStringExtra("season${getSeasonCnt-1}")?.let { Log.d("checkkk", it) }

        }

        if(getStyleCnt > 0) {
            for (i : Int in 0 until 9) {
                var temp = intent.getStringExtra("style$i")
                if (temp != null) {
                    str3 += intent.getStringExtra("style$i")
                    if (i <getStyleCnt -1) str3 += ", "
                    Log.d("checkk style","$i $temp")
                }
            }
            //  str3 += intent.getStringExtra("style${getStyleCnt-1}")
            //  intent.getStringExtra("style${getStyleCnt-1}")?.let { Log.d("checkkk", it) }
        }



        displayList.clear()
        FragmentOne.cardList.clear()

        retrofit = RetrofitClient.getInstance() // retrofit 초기화
        supplementService = retrofit.create(RetrofitService::class.java) // 서비스 가져오기

        getSearchList(supplementService)

//        fillTourData()
//        Thread.sleep(8000L)
//        var recyclerView = findViewById<RecyclerView>(R.id.recyclerview_recommend) // recyclerview id
////        var layoutManager = LinearLayoutManager(context)
////        recyclerView.layoutManager = layoutManager
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//        recyclerView.setHasFixedSize(true)
//        displayList.addAll(FragmentOne.cardList)
//
//        var adapter = MyAdapter(this,displayList)
//        recyclerView.adapter = adapter
        Log.d("test", "done func")


        // test 혼자
//        api.get_recom().enqueue(object : Callback<SpotArr>{
//            override fun onFailure(call: Call<SpotArr>, e: IOException) {}
//            override fun onResponse(call: Call<SpotArr>, response: Response<SpotArr>) {
//                val checkText : String = response.body()!!.toString()
//
//                Log.e("TEST1 ", checkText)
//
//                val jsonObject = JSONObject(checkText)
//                val spots = jsonObject.getJSONArray("spots")
//                val ratings = jsonObject.getJSONArray("ratings")
//                for (i in 0 .. 20)
//            }
//        })


//        val data = PostModel(binding.idedt.text.toString(),binding.pwdedt.text.toString(),binding.nickedt.text.toString())
//        api.post_users(data).enqueue(object : Callback<PostResult> {
//            override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
//                Log.d("log",response.toString())
//                Log.d("log", response.body().toString())
//                if(!response.body().toString().isEmpty())
//                    binding.text.setText(response.body().toString());
//            }
//
//            override fun onFailure(call: Call<PostResult>, t: Throwable) {
//                // 실패
//                Log.d("log",t.message.toString())
//                Log.d("log","fail")
//            }
//        })
//
//        api.get_users().enqueue(object : Callback<HTTP_GET_Model> {
//            override fun onResponse(call: Call<HTTP_GET_Model>, response: Response<HTTP_GET_Model>) {
//                Log.d("log",response.toString())
//                Log.d("log", response.body().toString())
//                if(!response.body().toString().isEmpty())
//                    binding.text.setText(response.body().toString());
//            }
//
//            override fun onFailure(call: Call<HTTP_GET_Model>, t: Throwable) {
//                // 실패
//                Log.d("log",t.message.toString())
//                Log.d("log","fail")
//            }
//        })

    }

    private fun getSearchList(service: RetrofitService) {
        var testView1 = findViewById<TextView>(R.id.textView22)
        var testView2 = findViewById<TextView>(R.id.textView33)
//        var testView3 = findViewById<TextView>(R.id.textView44)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerview_recommend)
        var recommend_list =  ArrayList<String>()
        testView1.text = "<추천 여행지>"
        myRef.get().addOnSuccessListener {
//            Log.d("http", "yes")

            spots1 = it.child(MainActivity.userId).child("location1").value.toString()
            spots2 = it.child(MainActivity.userId).child("location2").value.toString()
            spots3 = it.child(MainActivity.userId).child("location3").value.toString()
            ratings1 = it.child(MainActivity.userId).child("grade1").value.toString()
            ratings2 = it.child(MainActivity.userId).child("grade2").value.toString()
            ratings3 = it.child(MainActivity.userId).child("grade3").value.toString()

//            if (spots1 == "----------") {
//                spots1 = "용소웰빙공원"
//            }
//
//            if (spots2 == "----------") {
//                spots2 = "몰운대 (부산 국가지질공원)"
//            }
//
//            if (spots3 == "----------") {
//                spots3 = "일광해수욕장"
//            }
//
//
//        }.addOnFailureListener{
//            Log.e("firebase", "Error getting data", it)
//
//            spots1 = "용소웰빙공원"
//            ratings1 = "2.5"
//            spots2 = "몰운대 (부산 국가지질공원)"
//            ratings2 = "3.5"
//            spots3 = "일광해수욕장"
//            ratings3 = "3"
            //  }
//
//        Log.d("reco", spots1)
//        Log.d("reco", ratings1)
//        Log.d("reco", spots2)
//        Log.d("reco", ratings2)
//        Log.d("reco", spots3)
//        Log.d("reco", ratings3)

            //service.requestList(spots1,ratings1,spots2,ratings2, spots3,ratings3)


            //if(spots1.isNullOrEmpty() && spots2.isNullOrEmpty() && spots3.isNullOrEmpty() && ratings1.isNullOrEmpty()&& ratings2.isNullOrEmpty()&& ratings3.isNullOrEmpty()){
            service.requestList(spots1,ratings1,spots2,ratings2,spots3,ratings3)
                //service.requestList("용소웰빙공원", "3.5", "몰운대 (부산 국가지질공원)", "4.5", "일광해수욕장", "4")
                .enqueue(object : Callback<List<DataModels>> {
                    override fun onFailure(call: Call<List<DataModels>>, error: Throwable) {
                        Log.d("TAG", "실패 원인: {$error}")
                        testView2.text = "result : d"
                    }

                    override fun onResponse(
                        call: Call<List<DataModels>>,
                        response: Response<List<DataModels>>
                    ) {
                        Log.d("PLZZZZZZZZZZZZZZ", response.body().toString())
                        var data: List<DataModels>? = response.body()
                        //var num: Int = 0


                        //testView3.append("$spots1 \n")
                        var cnt =0;
                        for (i in 0..19) { // 0부터 19까지

                            var pred_spots: String = data?.get(i)?.getspots()!! // 모델에서 받아온 지역
                            var pred_ratings: String = data?.get(i)?.getratings()!!

//                            testView2.append("${i+1} - $pred_spots\n")

//                            var idx = nameArr[pred_spots]
//                            testView2.append("$pred_spots\n")
//                            FragmentOne.cardList.add(
//                                TourData(
//                                    pred_spots,
//                                    it.child("$idx").child("image").value.toString()
//                                )
//                            )

//                            if (it.child("$idx").child("GRP_NM").value.toString()
//                                    .contains("$str1") &&
//                                (it.child("$idx").child("SEASON_NM").value.toString()
//                                    .contains("$str2") || it.child("$idx")
//                                    .child("SEASON_NM").value.toString()
//                                    .contains("사계절")) &&
//                                it.child("$idx").child("IEM_NM").value.toString()
//                                    .contains("$str3")
//                            ) {
//                                cnt++
//                                            testView2.append("$cnt - $pred_spots\n")
//                                //recommend_list.add("$pred_spots")
//
//
//
//                            }

                            myRef2.get().addOnSuccessListener {
                                Log.d("test", "start")
                                for (j in 1..46) {
                                    spot_name =
                                        it.child("$j")
                                            .child("PLACE_NM").value.toString() // location 위치 기준
                                    if (pred_spots == spot_name) {


                                        if (it.child("$j").child("GRP_NM").value.toString()
                                                .contains("$str1") &&
                                            (it.child("$j").child("SEASON_NM").value.toString()
                                                .contains("$str2") || it.child("$j")
                                                .child("SEASON_NM").value.toString()
                                                .contains("사계절")) &&
                                            it.child("$j").child("IEM_NM").value.toString()
                                                .contains("$str3")
                                        ) {
                                            cnt++
                                            testView2.append("$cnt - $pred_spots\n")
                                            //recommend_list.add("$pred_spots")



                                        }


                                    }
                                }

                            }

                            //testView3.append("$pred_spots and  $pred_ratings \n")

                            //reponse.body()는 PlayerList를 반환한다.
                        }

                        Log.d("test", "done")
                    }
                })
            //}
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        displayList.addAll(FragmentOne.cardList)

        var adapter = MyAdapter(this,displayList)
        recyclerView.adapter = adapter

    }

    fun fillTourData() {
        FragmentOne.resultList.clear()
        FragmentOne.cardList.clear()
        for(i in 0..3) {
            var spotName : String = "test"// spots[i]
            var idx : String = "test"// categorys[i]
            var image_url : String = "http://tong.visitkorea.or.kr/cms/resource/95/2675495_image2_1.jpg"

//            FragmentOne.resultList.add(
//                TourData(
//                    spotName,
//                    category,
//                )
//            )


            FragmentOne.cardList.add(
                TourData(
                    spotName,
                    image_url
                )
            )

        }
    }
}