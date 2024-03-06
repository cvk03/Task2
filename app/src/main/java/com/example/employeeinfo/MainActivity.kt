package com.example.employeeinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.employeeinfo.dashboard.Dashboard
import com.example.employeeinfo.employe_einfo.EmployeeInfo
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(Dashboard())

        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(Dashboard())
                    true
                }
                R.id.user -> {
                    loadFragment(EmployeeInfo())
                    true
                }

                else -> {loadFragment(Dashboard())
                    true}
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame1,fragment)
        transaction.commit()
    }


}