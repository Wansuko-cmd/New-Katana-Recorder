package com.wsr.katanarecorder.main.list.detail

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.wsr.katanarecorder.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("ID", 404)
        Log.d("id", id.toString())

        supportFragmentManager.findFragmentById(R.id.list_detail_fragment_container)?.let {
            val navController = it.findNavController()

            val navGraph = navController.navInflater.inflate(R.navigation.list_detail_navigation)

            navController.setGraph(R.navigation.list_detail_navigation)
        }
    }
}