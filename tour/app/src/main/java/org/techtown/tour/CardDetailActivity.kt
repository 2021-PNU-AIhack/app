package org.techtown.tour

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class CardDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        var spotImage : ImageView = findViewById(R.id.item_image)
        var wordImage : ImageView = findViewById(R.id.word_image)
        var spotNameTv : TextView = findViewById(R.id.spot_name)
        var spotDetailTv : TextView = findViewById(R.id.spot_detail)

        val urlImage: URL = URL("https://www.visitbusan.net/uploadImgs/files/cntnts/20191229160529389_ttiel")

        // async task to get bitmap from url
        val result: kotlinx.coroutines.Deferred<Bitmap?> = GlobalScope.async {
            urlImage.toBitmap()
        }

        GlobalScope.launch(Dispatchers.Main) {
            // show bitmap on image view when available
            spotImage.setImageBitmap(result.await())
        }

    }
}