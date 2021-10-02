package org.techtown.tour

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.location.Address
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

//    var latlngdata = arrayListOf<LatLngData>()
////    lateinit var marker_view
////    lateinit var tag_marker
//    val marker_view = LayoutInflater.from(context).inflate(R.layout.marker ,null)
//    val tag_marker = marker_view.findViewById(R.id.tv_marker) as TextView


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_map, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment

        mapFragment.getMapAsync(this)

//        latlngdata.add(LatLngData(1, LatLng(35.162339, 129.108509), "가"))
//        latlngdata.add(LatLngData(2, LatLng(35.224836, 129.088285), "나"))
//        latlngdata.add(LatLngData(3, LatLng(35.080117, 129.048376), "다"))
//
//        for (i in latlngdata.indices) {
//            addMarker(latlngdata[i], false)
//        }
//
//        mMap.setOnMarkerClickListener(object: GoogleMap.OnMarkerClickListener {
//            override fun onMarkerClick(marker: Marker): Boolean {
//                val center: CameraUpdate = CameraUpdateFactory.newLatLng(marker.getPosition())
//                mMap.animateCamera(center)
//                changeSelectedMarker(marker)
//                return true
//            }
//        })
//
//        mMap.setOnMapClickListener (object: GoogleMap.OnMapClickListener{
//            override fun onMapClick(p0: LatLng?) {
//                changeSelectedMarker(null);
//            }
//        })

        // Inflate the layout for this fragment

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val marker = LatLng(35.241615, 128.695587)
        mMap.addMarker(MarkerOptions().position(marker).title("Marker LAB"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker))
    }

//    private fun setCustomMarkerView() {
//        marker_view = LayoutInflater.from(context).inflate(R.layout.marker ,null)
//        tag_marker = marker_view.findViewById(R.id.tv_marker) as TextView
//    }

//    private fun addMarker(latlngdata: LatLngData, isSelectedMarker:Boolean): Marker {
//        var list: List<Address>? = null
//        var markerOptions = MarkerOptions()
//        if (isSelectedMarker) {
//            tag_marker.setBackgroundResource(R.drawable.map_mark)
//            tag_marker.setTextColor(Color.WHITE)
//        } else {
//            tag_marker.setBackgroundResource(R.drawable.map_mark)
//            tag_marker.setTextColor(Color.BLACK)
//        }
//
//        markerOptions.position(latlngdata.latlng)
//        tag_marker.setText(latlngdata.tag)
//        markerOptions.icon(
//            BitmapDescriptorFactory.fromBitmap(createDrawableFromView(requireContext(), marker_view
//            )
//            )
//        )
//        return mMap.addMarker(markerOptions)
//    }
//
////    private fun addMarker(marker: Marker, isSelectedMarker: Boolean): Marker {
////        val lat: Double = marker.getPosition().latitude
////        val lon: Double = marker.getPosition().longitude
////        val tag: String = marker.getTitle()
////        val temp = MarkerItem(lat, lon, price)
////        return addMarker(temp, isSelectedMarker)
////    }
//
//    private fun createDrawableFromView(context: Context, view: View): Bitmap {
//        val displayMetrics = DisplayMetrics()
//        (context as Activity).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics)
//        view.setLayoutParams(
//            ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//        )
//        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
//        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
//        view.buildDrawingCache()
//        val bitmap: Bitmap = Bitmap.createBitmap(
//            view.getMeasuredWidth(),
//            view.getMeasuredHeight(),
//            Bitmap.Config.ARGB_8888
//        )
//        val canvas = Canvas(bitmap)
//        view.draw(canvas)
//        return bitmap
//    }
//
//    private fun changeSelectedMarker(marker: Marker?) {
//        // 선택했던 마커 되돌리기
////        if(selectedMarker != marker) {
////            if (selectedMarker != null) {
////                addMarker(selectedMarker!!, false)
////                selectedMarker!!.remove()
////            }
////
////            // 선택한 마커 표시
////            if (marker != null) {
////                addMarker(marker, true)
////                marker.remove()
////            }
////            else
////                selectedMarker = null
////        }
//    }

}