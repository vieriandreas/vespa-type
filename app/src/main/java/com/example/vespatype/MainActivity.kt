package com.example.vespatype

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvVespa: RecyclerView
    private val list = ArrayList<Vespa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvVespa = findViewById(R.id.rv_vespa)
        rvVespa.setHasFixedSize(true)

        list.addAll(getListVespa())
        showRecyclerList()
    }

    private fun getListVespa(): ArrayList<Vespa> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listVespa = ArrayList<Vespa>()
        for (i in dataName.indices) {
            val vespa = Vespa(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listVespa.add(vespa)
        }
        return listVespa
    }

    private fun  showRecyclerList() {
        rvVespa.layoutManager = LinearLayoutManager(this)
        val listVespaAdapter = ListVespaAdapter(list)
        rvVespa.adapter = listVespaAdapter

        listVespaAdapter.setOnItemClickCallback(object : ListVespaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Vespa) {
                showSelectedVespa(data)
            }
        })
    }

    private fun showSelectedVespa(vespa: Vespa) {
        Toast.makeText(this, "Kamu memilih " + vespa.name, Toast.LENGTH_SHORT).show()
    }
}