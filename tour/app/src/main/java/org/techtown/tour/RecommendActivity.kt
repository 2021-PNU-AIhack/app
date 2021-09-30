package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RecommendActivity : AppCompatActivity() {

    val displayList = ArrayList<TourData>()
    val spots = arrayOf("1", "2","3","4")
    val categorys = arrayOf("5", "6", "7", "8")

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

        Log.d("checkkk", getWhoCnt.toString())
        Log.d("checkkk", getSeasonCnt.toString())
        Log.d("checkkk", getStyleCnt.toString())

        if(getWhoCnt > 0) {
            if (getWhoCnt >1) {
                for (i : Int in 0 until getWhoCnt-1) {
                    str1 += intent.getStringExtra("who$i")
                    str1 += ", "
                    intent.getStringExtra("who$i")?.let { Log.d("checkkk", it) }
                }
            }
            str1 += intent.getStringExtra("who${getWhoCnt-1}")
            intent.getStringExtra("who${getWhoCnt-1}")?.let { Log.d("checkkk", it) }
        }

        if(getSeasonCnt > 0) {
            if (getSeasonCnt >1) {
                for (i : Int in 0 until getSeasonCnt-1) {
                    str2 += intent.getStringExtra("season$i")
                    str2 += ", "
                    intent.getStringExtra("season$i")?.let { Log.d("checkkk", it) }
                }
            }
            str2 += intent.getStringExtra("season${getSeasonCnt-1}")
            intent.getStringExtra("season${getSeasonCnt-1}")?.let { Log.d("checkkk", it) }

        }

        if(getStyleCnt > 0) {
            if (getStyleCnt >1) {
                for (i : Int in 0 until getStyleCnt-1) {
                    str3 += intent.getStringExtra("style$i")
                    str3 += ", "
                    intent.getStringExtra("style$i")?.let { Log.d("checkkk", it) }
                }
            }
            str3 += intent.getStringExtra("style${getStyleCnt-1}")
            intent.getStringExtra("style${getStyleCnt-1}")?.let { Log.d("checkkk", it) }
        }

        testView1.text = str1
        testView2.text = str2
        testView3.text = str3

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