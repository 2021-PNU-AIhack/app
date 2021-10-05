package org.techtown.tour

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.techtown.tour.databinding.ActivityRateBinding
import java.net.URL
import kotlin.properties.Delegates

class CardDetailActivity : AppCompatActivity() {

    lateinit var mapX : String
    lateinit var mapY : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        val spotImage : ImageView = findViewById(R.id.spot_image)
//        val wordImage : ImageView = findViewById(R.id.word_image)
        val spotNameTv : TextView = findViewById(R.id.spot_name)
        val spotDetailTv : TextView = findViewById(R.id.spot_detail)
        val mapBtn : Button = findViewById(R.id.mapBtn)
        val nearSpotBtn : Button = findViewById(R.id.nearSpotBtn)

        val nameArr = mapOf("용소웰빙공원" to 1,"몰운대 (부산 국가지질공원)" to 2,"일광해수욕장" to 3,"을숙도생태공원" to 4,"삼락생태공원" to 5,"대저생태공원" to 6,"흰여울문화마을" to 7,"감천문화마을" to 8,"구덕문화공원" to 9,"동래시장" to 10,"부산어촌민속관" to 11,"해운대시장" to 12,"조선통신사역사관" to 13,"아미산 전망대" to 14,"송도해수욕장" to 15,"태종대 (부산 국가지질공원)" to 16,"다대포해수욕장" to 17,"광안리해수욕장" to 18,"송정해수욕장" to 19,"오륙도 (부산 국가지질공원)" to 20,"암남공원" to 21,"청사포" to 22,"황령산 전망대" to 23,"가덕도 연대봉" to 24,"백양산 (부산 국가지질공원)" to 25,"성지곡수원지" to 26,"승학산" to 27,"아홉산숲" to 28,"일광해수욕장" to 29,"임랑해수욕장" to 30,"봉래산" to 31,"회동수원지" to 32,"부산시민공원" to 33,"용두산공원" to 34,"민락수변공원" to 35,"누리마루 APEC하우스" to 36,"어린이대공원" to 37,"금강공원" to 38,"대신공원" to 39,"수영사적공원" to 40,"화명생태공원" to 41,"우장춘기념관" to 42,"요산문학관" to 43,"수산과학관" to 44,"부산해양자연사박물관" to 45,"부산기상관측소" to 46)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("image")
        val idx = nameArr[name].toString()

        spotNameTv.text = name

//        wordImage.setImageResource(R.drawable.)

        val urlImage: URL = URL(image)

        // async task to get bitmap from url
        val result: kotlinx.coroutines.Deferred<Bitmap?> = GlobalScope.async {
            urlImage.toBitmap()
        }

        val database = Firebase.database
        val myRef = database.getReference("location")

        GlobalScope.launch(Dispatchers.Main) {
            // show bitmap on image view when available
            spotImage.setImageBitmap(result.await())
        }

        myRef.get().addOnSuccessListener {
            spotDetailTv.text = it.child(idx).child("ETC_CN").value.toString()
            mapX = it.child(idx).child("TRRSRT_LA").value.toString()
            mapY = it.child(idx).child("TRRSRT_LO").value.toString()

        }.addOnFailureListener{
            spotDetailTv.text = "error"
            mapX = "35.230994"
            mapY = "129.082343"
        }
        Thread.sleep(250L)

        mapBtn.setOnClickListener {
            val mapIntent: Intent = Intent(this, MapActivity::class.java)
            mapIntent.putExtra("x",mapX)
            mapIntent.putExtra("y",mapY)
            mapIntent.putExtra("name",name)
            startActivity(mapIntent)
        }

        nearSpotBtn.setOnClickListener {
            val nearSpotIntent : Intent = Intent(this, MapActivity::class.java)
            startActivity(nearSpotIntent)
        }

    }
}