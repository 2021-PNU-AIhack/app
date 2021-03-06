package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.techtown.tour.databinding.ActivityMainBinding
import org.techtown.tour.databinding.ActivityRateBinding
import kotlinx.android.synthetic.main.activity_rate.*


class RateActivity : AppCompatActivity() {

    lateinit var option : Spinner
    private lateinit var binding : ActivityRateBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        option = findViewById<Spinner>(R.id.spinner_1)


        //val btn = findViewById<Button>(R.id.Btn) as Button


        binding.Btn.setOnClickListener{

            val location1 = binding.spinner1.getSelectedItem().toString()
            val location2 = binding.spinner2.getSelectedItem().toString()
            val location3 = binding.spinner3.getSelectedItem().toString()
            val grade1 = binding.ratingBarOne.getRating().toString()
            val grade2 = binding.ratingBarTwo.getRating().toString()
            val grade3 = binding.ratingBarThree.getRating().toString()

            database = FirebaseDatabase.getInstance().getReference("user")

            val user= User(grade1,grade2,grade3,location1,location2,location3)
            database.child(MainActivity.userId).setValue(user).addOnSuccessListener {
                    //binding.spinner1
                    //binding.spinner2.clear()
                    //binding.spinner3.clear()
                    //binding.ratingBarOne.clear()
                    //binding.ratingBarTwo.clear()
                    //binding.ratingBarThree.clear()

                Toast.makeText(this,"success", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this,"fail", Toast.LENGTH_SHORT).show()
            }


            //super.onBackPressed();
            //stopPlay(); //??? ?????????????????? ??????????????? ?????? ?????? ?????????????????? ??????
            Toast.makeText(this,"?????? ?????? ??????", Toast.LENGTH_SHORT).show()
            finish();   //?????? ???????????? ??????



        }

    }
}