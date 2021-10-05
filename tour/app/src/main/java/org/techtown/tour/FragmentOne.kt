package org.techtown.tour

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.inject.Deferred
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.techtown.tour.FragmentOne.Companion.pos
import java.io.IOException
import java.net.URL
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentOne : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val database = Firebase.database
    val myRef = database.getReference("location")

    val displayList = ArrayList<TourData>()
    var spotNameList = ArrayList<String>()
    var idxList = ArrayList<String>()
    var imageUrlList = ArrayList<String>()
    lateinit var v : View
    val spots = arrayOf("부산", "경상도","서울","대전","충청","강원도")
    val categorys = arrayOf("바다", "숙박", "볼거리", "교통", "느긋", "감자")

    companion object {
        var resultList = arrayListOf<TourData>()
        var position = 0
        var pos = 0
        val cardList : ArrayList<TourData> = ArrayList<TourData>()
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentOne().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_one,container,false)

        var searchView = v.findViewById<View>(R.id.search_bar1)
        var settingBtn = searchView.findViewById<ImageView>(R.id.setting)
        var recoBtn = v.findViewById<Button>(R.id.recommendBtn)
        var rateBtn = v.findViewById<Button>(R.id.ratingBtn)

        displayList.clear()
        cardList.clear()

//        myRef.addValueEventListener(object: ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
////                val test = snapshot.child("sofa")
//                Log.e("snap", "good")
//                for(ds in snapshot.children){
//                    ds.child("PLACE_NM").toString()
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // 읽어오기에 실패했을 때
//                Log.e("실패", "후")
//            }
//        })

//        for (i in 1..46) {
//            var spotName : String = "error"
//            var idx : String = "errror"
//            var image_url : String = "http://tong.visitkorea.or.kr/cms/resource/95/2675495_image2_1.jpg"
//
//            cardList.add(
//                TourData(
//                    spotName,
//                    idx,
//                    image_url
//                )
//            )
//        }

//        myRef.addValueEventListener(object: ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                Log.d("success", "yes")
//                for (i in 1..46) {
////                    var spotName : String = snapshot.child("$i").child("PLACE_NM").toString()
////                    var idx : String = snapshot.child("$i").child("idx").toString()
////                    var image_url : String = snapshot.child("$i").child("image").toString()
//
//                    cardList.add(
//                        TourData(
//                            snapshot.child("$i").child("PLACE_NM").toString(),
//                            snapshot.child("$i").child("idx").toString(),
//                            snapshot.child("$i").child("image").toString()
//                        )
//                    )
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // 읽어오기에 실패했을 때
//                Log.e("실패", "후")
//
//                for (i in 1..46) {
//                    var spotName : String = "error"
//                    var idx : String = "errror"
//                    var image_url : String = "http://tong.visitkorea.or.kr/cms/resource/95/2675495_image2_1.jpg"
//
//                    cardList.add(
//                        TourData(
//                            spotName,
//                            idx,
//                            image_url
//                        )
//                    )
//                }
//            }
//        })

        myRef.get().addOnSuccessListener {
            Log.d("success", "yes")
            for (i in 1..5) {
                var spotName : String = it.child("$i").child("PLACE_NM").value.toString()
                var idx : String = it.child("$i").child("idx").value.toString()
                var image_url : String = it.child("$i").child("image").value.toString()

                Log.d("success", "$spotName,  $idx,  $image_url")

                cardList.add(
                    TourData(
                        spotName,
                        idx,
                        image_url
                    )
                )
            }
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)

            for (i in 1..5) {
                var spotName : String = "error"
                var idx : String = "errror"
                var image_url : String = "http://tong.visitkorea.or.kr/cms/resource/95/2675495_image2_1.jpg"

                cardList.add(
                    TourData(
                        spotName,
                        idx,
                        image_url
                    )
                )
            }
        }

//        displayList.clear()
//        cardList.clear()
//        fillTourData()

        var recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview_main) // recyclerview id
//        var layoutManager = LinearLayoutManager(context)
//        recyclerView.layoutManager = layoutManager
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)
        displayList.addAll(cardList)

        var adapter = MyAdapter(requireContext(),displayList)
        recyclerView.adapter = adapter

        settingBtn.setOnClickListener {
            var settingIntent: Intent = Intent(context, SettingActivity::class.java)
            startActivity(settingIntent)
        }

        recoBtn.setOnClickListener {
            var recommendIntent: Intent = Intent(context, GetInfoActivity::class.java)
            startActivity(recommendIntent)
        }

        rateBtn.setOnClickListener {
            var rateIntent: Intent = Intent(context, RateActivity::class.java)
            startActivity(rateIntent)
        }

        return v
    }

    fun fillTourData() {
        resultList.clear()
        cardList.clear()
        for(i in 1..5) {
//            lateinit var spotName : String // spots[i]
//            lateinit var idx : String // categorys[i]
//            lateinit var image_url : String

            myRef.child("$i").child("PLACE_NM").get().addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                spotNameList.add(it.value.toString())
//                spotName = it.value.toString()
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
                spotNameList.add("error")
//                spotName = "error"
            }

            myRef.child("$i").child("idx").get().addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                idxList.add(it.value.toString())
//                idx = it.value.toString()
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
                idxList.add("error")
//                idx = "error"
            }

            myRef.child("$i").child("image").get().addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                imageUrlList.add(it.value.toString())
//                image_url = it.value.toString()
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
                imageUrlList.add("http://tong.visitkorea.or.kr/cms/resource/95/2675495_image2_1.jpg")
//                image_url = "http://tong.visitkorea.or.kr/cms/resource/95/2675495_image2_1.jpg"
            }

//                resultList.add(
//                    TourData(
//                        spotName,
//                        idx,
//                        image_url
//                    )
//                )


//                cardList.add(
//                    TourData(
//                        spotName,
//                        idx,
//                        image_url
//                    )
//                )

            }

//            Log.d("plzzzzz",spotNameList.toString())
//            Log.d("plzzzzz",idxList.toString())


//            for (i in 0..4) {
//                cardList.add(
//                    TourData(
//                        spotNameList[i],
//                        idxList[i],
//                        imageUrlList[i]
//                    )
//                )
//            }
        }


    }

class MyAdapter(val context: Context, var spotList: ArrayList<TourData>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): MyViewHolder {
        var v: View = LayoutInflater.from(viewgroup.context).inflate(R.layout.card_layout, viewgroup, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = spotList[position]
        holder.itemView.setOnClickListener {
            itemClickListner!!.onClick(it,position)
        }

        holder.apply {
            bind(item,context)
        }

    }

    override fun getItemCount(): Int {
        return spotList.size
    }
    interface OnItemClickListner {
        fun onClick(v:View, position: Int)
    }
    private var itemClickListner: OnItemClickListner? = null

    fun setItemClickListner(itemClickListner: OnItemClickListner) {
        this.itemClickListner = itemClickListner
    }

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var itemimage: ImageView = itemview.findViewById(R.id.item_image)
        var itemdetail: TextView = itemview.findViewById(R.id.item_detail)

        fun bind (spotData:TourData, context: Context) {

            itemView.setOnClickListener {
                pos = adapterPosition
                val cardViewIntent = Intent(context, CardDetailActivity::class.java).apply{
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }

//            val urlImage: URL = URL("https://images.pexels.com/photos/954129/" +
//                    "pexels-photo-954129.jpeg?" +
//                    "auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260")

            val urlImage: URL = URL(spotData.imageUrl)

            // async task to get bitmap from url
            val result: kotlinx.coroutines.Deferred<Bitmap?> = GlobalScope.async {
                urlImage.toBitmap()
            }

            GlobalScope.launch(Dispatchers.Main) {
                // show bitmap on image view when available
                itemimage.setImageBitmap(result.await())
            }

//            itemtitle.text = spotData.spotName
            itemdetail.text = spotData.spotName
        }
    }
}

// extension function to get bitmap from url
fun URL.toBitmap(): Bitmap?{
    return try {
        BitmapFactory.decodeStream(openStream())
    }catch (e: IOException){
        null
    }
}



