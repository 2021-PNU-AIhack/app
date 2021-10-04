package org.techtown.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*

class GradeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)


        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val location : DatabaseReference = database.getReference("location")
        val grade : DatabaseReference = database.getReference("grade")
        val location2 : DatabaseReference = database.getReference("location")
        val grade2 : DatabaseReference = database.getReference("grade")

        location.setValue("부산 금정구 ~~")
        grade.setValue("3")
        location2.setValue("부산 금정구 ")
        grade2.setValue("4")


    }
}