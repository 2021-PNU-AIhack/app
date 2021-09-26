package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class CardDetailActivity : AppCompatActivity() {

    private val mapfl: FrameLayout by lazy {
        findViewById(R.id.map_frame)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        supportFragmentManager.beginTransaction().add(mapfl.id,MapFragment()).commit()
        supportActionBar!!.hide()
    }
}