package org.techtown.tour

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat

class GetInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_info)

        var nextBtn = findViewById<Button>(R.id.intentBtn)

        var who1Btn = findViewById<Button>(R.id.who1_Btn)
        var who2Btn = findViewById<Button>(R.id.who2_Btn)
        var who3Btn = findViewById<Button>(R.id.who3_Btn)
        var who4Btn = findViewById<Button>(R.id.who4_Btn)
        var who5Btn = findViewById<Button>(R.id.who5_Btn)
        var who6Btn = findViewById<Button>(R.id.who6_Btn)

        var season1Btn = findViewById<Button>(R.id.season1_Btn)
        var season2Btn = findViewById<Button>(R.id.season2_Btn)
        var season3Btn = findViewById<Button>(R.id.season3_Btn)
        var season4Btn = findViewById<Button>(R.id.season4_Btn)

        var style1Btn = findViewById<Button>(R.id.style1_Btn)
        var style2Btn = findViewById<Button>(R.id.style2_Btn)
        var style3Btn = findViewById<Button>(R.id.style3_Btn)
        var style4Btn = findViewById<Button>(R.id.style4_Btn)
        var style5Btn = findViewById<Button>(R.id.style5_Btn)
        var style6Btn = findViewById<Button>(R.id.style6_Btn)
        var style7Btn = findViewById<Button>(R.id.style7_Btn)
        var style8Btn = findViewById<Button>(R.id.style8_Btn)
        var style9Btn = findViewById<Button>(R.id.style9_Btn)

        var whoCheck = arrayOf(0,0,0,0,0,0)

        var seasonCheck = arrayOf(0,0,0,0)

        var styleCheck = arrayOf(0,0,0,0,0,0,0,0,0)

        val whoArr = arrayOf("가족", "아이", "커플", "부모", "친구", "혼자")
        val seasonArr = arrayOf("봄", "여름", "가을", "겨울")
        val styleArr = arrayOf("자연", "공원", "걷기", "쇼핑", "역사", "문화", "체험", "이색여행", "기타")


        who1Btn.setOnClickListener {
            if (whoCheck[0] == 0) {
                who1Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                who1Btn.setTextColor(Color.rgb(92,196,133))
                whoCheck[0] = 1
            }
            else {
                who1Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                who1Btn.setTextColor(Color.rgb(102,102,102))
                whoCheck[0] = 0
            }
        }

        who2Btn.setOnClickListener {
            if (whoCheck[1] == 0) {
                who2Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                who2Btn.setTextColor(Color.rgb(92,196,133))
                whoCheck[1] = 1
            }
            else {
                who2Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                who2Btn.setTextColor(Color.rgb(102,102,102))
                whoCheck[1] = 0
            }
        }

        who3Btn.setOnClickListener {
            if (whoCheck[2] == 0) {
                who3Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                who3Btn.setTextColor(Color.rgb(92,196,133))
                whoCheck[2] = 1
            }
            else {
                who3Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                who3Btn.setTextColor(Color.rgb(102,102,102))
                whoCheck[2] = 0
            }
        }

        who4Btn.setOnClickListener {
            if (whoCheck[3] == 0) {
                who4Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                who4Btn.setTextColor(Color.rgb(92,196,133))
                whoCheck[3] = 1
            }
            else {
                who4Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                who4Btn.setTextColor(Color.rgb(102,102,102))
                whoCheck[3] = 0
            }
        }

        who5Btn.setOnClickListener {
            if (whoCheck[4] == 0) {
                who5Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                who5Btn.setTextColor(Color.rgb(92,196,133))
                whoCheck[4] = 1
            }
            else {
                who5Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                who5Btn.setTextColor(Color.rgb(102,102,102))
                whoCheck[4] = 0
            }
        }

        who6Btn.setOnClickListener {
            if (whoCheck[5] == 0) {
                who6Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                who6Btn.setTextColor(Color.rgb(92,196,133))
                whoCheck[5] = 1
            }
            else {
                who6Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                who6Btn.setTextColor(Color.rgb(102,102,102))
                whoCheck[5] = 0
            }
        }

        season1Btn.setOnClickListener {
            if (seasonCheck[0] == 0) {
                season1Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                season1Btn.setTextColor(Color.rgb(92,196,133))
                seasonCheck[0] = 1
            }
            else {
                season1Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                season1Btn.setTextColor(Color.rgb(102,102,102))
                seasonCheck[0] = 0
            }
        }

        season2Btn.setOnClickListener {
            if (seasonCheck[1] == 0) {
                season2Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                season2Btn.setTextColor(Color.rgb(92,196,133))
                seasonCheck[1] = 1
            }
            else {
                season2Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                season2Btn.setTextColor(Color.rgb(102,102,102))
                seasonCheck[1] = 0
            }
        }

        season3Btn.setOnClickListener {
            if (seasonCheck[2] == 0) {
                season3Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                season3Btn.setTextColor(Color.rgb(92,196,133))
                seasonCheck[2] = 1
            }
            else {
                season3Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                season3Btn.setTextColor(Color.rgb(102,102,102))
                seasonCheck[2] = 0
            }
        }

        season4Btn.setOnClickListener {
            if (seasonCheck[3] == 0) {
                season4Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                season4Btn.setTextColor(Color.rgb(92,196,133))
                seasonCheck[3] = 1
            }
            else {
                season4Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                season4Btn.setTextColor(Color.rgb(102,102,102))
                seasonCheck[3] = 0
            }
        }

        style1Btn.setOnClickListener {
            if (styleCheck[0] == 0) {
                style1Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style1Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[0] = 1
            }
            else {
                style1Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style1Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[0] = 0
            }
        }

        style2Btn.setOnClickListener {
            if (styleCheck[1] == 0) {
                style2Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style2Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[1] = 1
            }
            else {
                style2Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style2Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[1] = 0
            }
        }

        style3Btn.setOnClickListener {
            if (styleCheck[2] == 0) {
                style3Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style3Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[2] = 1
            }
            else {
                style3Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style3Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[2] = 0
            }
        }

        style4Btn.setOnClickListener {
            if (styleCheck[3] == 0) {
                style4Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style4Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[3] = 1
            }
            else {
                style4Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style4Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[3] = 0
            }
        }

        style5Btn.setOnClickListener {
            if (styleCheck[4] == 0) {
                style5Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style5Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[4] = 1
            }
            else {
                style5Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style5Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[4] = 0
            }
        }

        style6Btn.setOnClickListener {
            if (styleCheck[5] == 0) {
                style6Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style6Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[5] = 1
            }
            else {
                style6Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style6Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[5] = 0
            }
        }

        style7Btn.setOnClickListener {
            if (styleCheck[6] == 0) {
                style7Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style7Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[6] = 1
            }
            else {
                style7Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style7Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[6] = 0
            }
        }

        style8Btn.setOnClickListener {
            if (styleCheck[7] == 0) {
                style8Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style8Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[7] = 1
            }
            else {
                style8Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style8Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[7] = 0
            }
        }

        style9Btn.setOnClickListener {
            if (styleCheck[8] == 0) {
                style9Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_background))
                style9Btn.setTextColor(Color.rgb(92,196,133))
                styleCheck[8] = 1
            }
            else {
                style9Btn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.btn_clicked_out))
                style9Btn.setTextColor(Color.rgb(102,102,102))
                styleCheck[8] = 0
            }
        }

        nextBtn.setOnClickListener {
            val recommendIntent: Intent = Intent(this, RecommendActivity::class.java)

            var cnt = 0
            for(i : Int in 0..5) {
                if (whoCheck[i] == 1) {
                    recommendIntent.putExtra("who$i", whoArr[i])
                    cnt++
//                    Log.d("checkkkWho", whoArr[i])
                }
            }
//            Log.d("checkkkWhoCnt", cnt.toString())
            recommendIntent.putExtra("whoCnt", cnt)

            cnt = 0
            for(i : Int in 0..3) {
                if (seasonCheck[i] == 1) {
                    recommendIntent.putExtra("season$i", seasonArr[i])
                    cnt++
//                    Log.d("checkkkSeason", seasonArr[i])
                }
            }
//            Log.d("checkkkSeaasonCnt", cnt.toString())
            recommendIntent.putExtra("seasonCnt", cnt)

            cnt = 0
            for(i : Int in 0..8) {
                if (styleCheck[i] == 1) {
                    recommendIntent.putExtra("style$i", styleArr[i])
                    cnt++
//                    Log.d("checkkkStyle", styleArr[i])
                }
            }
//            Log.d("checkkkStyleCnt", cnt.toString())
            recommendIntent.putExtra("styleCnt", cnt)

            startActivity(recommendIntent)
        }
    }
}