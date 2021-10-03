package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.ArrayList

class RecommendActivity : AppCompatActivity() {

    val displayList = ArrayList<TourData>()
    var spots = arrayOf("1", "2","3","4")
    var categorys = arrayOf("5", "6", "7", "8")

//    val api = APIS.create();
    private lateinit var retrofit : Retrofit
    private lateinit var supplementService : RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        displayList.clear()
        FragmentOne.cardList.clear()
        fillTourData()

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerview_recommend) // recyclerview id
//        var layoutManager = LinearLayoutManager(context)
//        recyclerView.layoutManager = layoutManager
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        displayList.addAll(FragmentOne.cardList)

        var adapter = MyAdapter(this,displayList)
        recyclerView.adapter = adapter

        var testView1 = findViewById<TextView>(R.id.textView22)
        var testView2 = findViewById<TextView>(R.id.textView33)
        var testView3 = findViewById<TextView>(R.id.textView44)


        var getWhoCnt = intent.getIntExtra("whoCnt", 0)
        var getSeasonCnt = intent.getIntExtra("seasonCnt", 0)
        var getStyleCnt = intent.getIntExtra("styleCnt", 0)

        var str1 = ""
        var str2 = ""
        var str3 = ""

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
//            str3 += intent.getStringExtra("style${getStyleCnt-1}")
//            intent.getStringExtra("style${getStyleCnt-1}")?.let { Log.d("checkkk", it) }
        }

        testView1.text = str1
        testView2.text = str2
        testView3.text = str3

        retrofit = RetrofitClient.getInstance() // retrofit 초기화
        supplementService = retrofit.create(RetrofitService::class.java) // 서비스 가져오기

        getSearchList(supplementService)


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

    private fun getSearchList(service: RetrofitService){
        service.requestList("광안리해수욕장",3,"감천문화마을",4,"청사포",3).enqueue(object : Callback<SpotArr> {
            override fun onFailure(call: Call<SpotArr>, error: Throwable) {
                Log.d("TAG", "실패 원인: {$error}")
            }

            override fun onResponse(
                call: Call<SpotArr>,
                response: Response<SpotArr>
            ) {
                Log.d("PLZZZZZZZZZZZZZZ", response.body().toString())

                //reponse.body()는 PlayerList를 반환한다.
            }
        })
    }

    fun fillTourData() {
        FragmentOne.resultList.clear()
        FragmentOne.cardList.clear()
        for(i in 0..3) {
            var spotName : String = spots[i]
            var category : String = categorys[i]

            FragmentOne.resultList.add(
                TourData(
                    spotName,
                    category,
                )
            )


            FragmentOne.cardList.add(
                TourData(
                    spotName,
                    category
                )
            )

        }
    }
}