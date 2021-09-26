package org.techtown.tour

import android.content.Context
import android.content.Intent
import android.database.Cursor
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
import org.techtown.tour.FragmentOne.Companion.pos
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

    val displayList = ArrayList<TourData>()
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
        fillTourData()

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
        for(i in 0..5) {
            var spotName : String = spots[i]
            var category : String = categorys[i]

                resultList.add(
                    TourData(
                        spotName,
                        category,
                    )
                )


                cardList.add(
                    TourData(
                        spotName,
                        category
                    )
                )

            }
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
        var itemtitle: TextView = itemview.findViewById(R.id.item_title)
        var itemdetail: TextView = itemview.findViewById(R.id.item_detail)

        fun bind (spotData:TourData, context: Context) {

            itemView.setOnClickListener {
                pos = adapterPosition
                val cardViewIntent = Intent(context, CardDetailActivity::class.java).apply{
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
            itemtitle.text = spotData.spotName
            itemdetail.text = spotData.category
        }
    }
}



