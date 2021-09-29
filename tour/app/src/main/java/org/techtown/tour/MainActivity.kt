package org.techtown.tour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fl: FrameLayout by lazy {
        findViewById(R.id.main_frame)
    }
    private val bn: BottomNavigationView by lazy{
        findViewById(R.id.bottomNavigationView)
    }

    companion object {
        lateinit var userId : String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(fl.id,FragmentOne()).commit()
        supportActionBar!!.hide()

        userId = intent.getStringExtra("user_id").toString()
//        val emailId = intent.getStringExtra("email_id")
//
//        tv_user_id.text = "User ID :: $userId"
//        tv_email_id.text = "Email ID :: $emailId"
//
//        btn_logout.setOnClickListener{
//            FirebaseAuth.getInstance().signOut()
//
//            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
//            finish()
//        }

        bn.setOnNavigationItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.home -> FragmentOne()
                    else -> FragmentTwo()

                }
            )
            true
        }

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false
    }
    override fun onResume() {
        super.onResume()
        bn.setOnNavigationItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.home -> FragmentOne()
                    else -> FragmentTwo()

                }
            )
            true
        }

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(fl.id, fragment).commit()
    }
}