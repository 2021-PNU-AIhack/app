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

class CardDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        val spotImage : ImageView = findViewById(R.id.spot_image)
        val wordImage : ImageView = findViewById(R.id.word_image)
        val spotNameTv : TextView = findViewById(R.id.spot_name)
        val spotDetailTv : TextView = findViewById(R.id.spot_detail)
        val mapBtn : Button = findViewById(R.id.mapBtn)
        val nearSpotBtn : Button = findViewById(R.id.nearSpotBtn)

//        wordImage.setImageResource(R.drawable.)

        val urlImage: URL = URL("https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160529389_ttiel")

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

        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
//                val test = snapshot.child("sofa")
                for(ds in snapshot.children){
                    Log.e("snap", ds.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // 읽어오기에 실패했을 때
                Log.e("실패", "후")
            }
        })

//        myRef.child("1").child("PLACE_NM").get().addOnSuccessListener {
//            Log.i("firebase", "Got value ${it.value}")
//        }.addOnFailureListener{
//            Log.e("firebase", "Error getting data", it)
//        }

        mapBtn.setOnClickListener {
            val mapIntent: Intent = Intent(this, MapActivity::class.java)
            startActivity(mapIntent)
        }

        nearSpotBtn.setOnClickListener {
            val nearSpotIntent : Intent = Intent(this, MapActivity::class.java)
            startActivity(nearSpotIntent)
        }

    }

}