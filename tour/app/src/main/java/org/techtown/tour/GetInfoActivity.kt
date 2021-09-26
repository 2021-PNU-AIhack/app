package org.techtown.tour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GetInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_info)

        var nextBtn = findViewById<Button>(R.id.intentBtn)

        nextBtn.setOnClickListener {
            var recommendIntent: Intent = Intent(this, RecommendActivity::class.java)
            startActivity(recommendIntent)
        }
    }
}