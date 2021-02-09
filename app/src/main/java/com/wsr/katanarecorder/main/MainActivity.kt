package com.wsr.katanarecorder.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wsr.katanarecorder.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = supportFragmentManager.findFragmentById(R.id.main_fragment_container)
        val navView: BottomNavigationView = findViewById(R.id.main_bottom_navigation_view)

        navController?.let{
            navView.setupWithNavController(navController.findNavController())
        }
    }
}