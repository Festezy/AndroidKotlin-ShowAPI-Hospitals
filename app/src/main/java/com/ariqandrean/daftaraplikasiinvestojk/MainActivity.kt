package com.ariqandrean.daftaraplikasiinvestojk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowApps.setOnClickListener{
            setupListOfDataIntoRecyclerView()
        }
    }

    private fun setupListOfDataIntoRecyclerView() {
        rvItemList.layoutManager = LinearLayoutManager(this)

        //Ambil data OJK dari APiInterface & client
        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getAPPs().enqueue(object : Callback<ArrayList<HospitalsModel>>{
            override fun onFailure(call: Call<ArrayList<HospitalsModel>>, t: Throwable) {
                Toast.makeText(baseContext, "Data Downloading is failure", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<ArrayList<HospitalsModel>>,
                                    response: Response<ArrayList<HospitalsModel>>) {
                var appsData = response?.body()!!
                if (appsData.size > 0){
                    rvItemList.visibility = View.VISIBLE
                    tvNoRecordAvailable.visibility = View.GONE
                    rvItemList.adapter = MyAdapter(this@MainActivity, appsData)
                } else {
                    rvItemList.visibility = View.GONE
                    tvNoRecordAvailable.visibility = View.VISIBLE
                }
                Toast.makeText(baseContext, "Data downloading is success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}