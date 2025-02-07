package com.example.vespatype

import android.app.Person
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

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
    }


}