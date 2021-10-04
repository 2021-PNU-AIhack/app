package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MapActivity : AppCompatActivity() {

    private val mapfl: FrameLayout by lazy {
        findViewById(R.id.map_frame)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        supportFragmentManager.beginTransaction().add(mapfl.id,MapFragment()).commit()
        supportActionBar!!.hide()

    }
}