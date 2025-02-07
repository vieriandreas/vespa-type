package com.example.vespatype

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvDetailName:TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription:TextView = findViewById(R.id.tv_detail_description)
        val tvDetailPhoto:ImageView= findViewById(R.id.img_detail_photo)

        val dataVespa = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Vespa>("key_vespa", Vespa::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Vespa>("key_vespa")
        }

        Log.d("Vespa", dataVespa?.name ?: "data vespa Null")

        supportActionBar?.title = dataVespa?.name

        tvDetailName.text = dataVespa?.name
        tvDetailDescription.text = dataVespa?.description
        tvDetailPhoto.setImageResource(dataVespa!!.photo)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }


}