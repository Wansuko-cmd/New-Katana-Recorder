package com.wsr.katanarecorder.main.list.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.wsr.katanarecorder.R
import com.wsr.katanarecorder.main.list.detail.show.ListShowFragmentArgs

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("ID", 404)
        val args = ListShowFragmentArgs(id)

        /*val binding = ActivityDetailBinding.inflate(layoutInflater)
        binding.detailToolbar.inflateMenu(R.menu.list_detail_menu)

        val detailToolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.detail_toolbar)
        detailToolbar.inflateMenu(R.menu.list_detail_menu)*/

        Log.d("id", id.toString())

        supportFragmentManager.findFragmentById(R.id.list_detail_fragment_container)?.let {
            val navController = it.findNavController()

            navController.setGraph(R.navigation.list_detail_navigation, args.toBundle())
        }
    }
}