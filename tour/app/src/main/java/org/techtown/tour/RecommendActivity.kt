package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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