package org.techtown.tour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val words = arrayOf("Apple", "Banana", "cup", "drag", "eight")
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_gallery_item, words)
        autoCompleteTextView.setAdapter(adapter)

        button.setOnClickListener {
            textView.text = "test"
        }
    }
}