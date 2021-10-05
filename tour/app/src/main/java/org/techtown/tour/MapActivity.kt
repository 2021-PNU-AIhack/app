package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.gms.maps.model.LatLng

class MapActivity : AppCompatActivity() {

    private val mapfl: FrameLayout by lazy {
        findViewById(R.id.map_frame)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val name = intent.getStringExtra("name").toString()
        val x = intent.getStringExtra("x").toString().toDouble()
        val y = intent.getStringExtra("y").toString().toDouble()
        val mapXY = LatLng(x,y)

        supportFragmentManager.beginTransaction().add(mapfl.id,MapFragment(name,mapXY)).commit()
        supportActionBar!!.hide()

    }
}

