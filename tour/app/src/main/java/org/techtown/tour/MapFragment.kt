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
class MapFragment(val name : String, val xy : LatLng) : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_map, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment

        mapFragment.getMapAsync(this)

        // Inflate the layout for this fragment

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
//        val marker = LatLng(35.241615, 128.695587)
//        mMap.addMarker(MarkerOptions().position(marker).title("Marker LAB"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker))

//        val myLocation = LatLng(35.230994, 129.082343)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(xy))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15f))

        //마커 출력
        val marker = MarkerOptions()
            .position(xy)
            .title(name)
            .snippet(name)
        mMap?.addMarker(marker)

    }

}