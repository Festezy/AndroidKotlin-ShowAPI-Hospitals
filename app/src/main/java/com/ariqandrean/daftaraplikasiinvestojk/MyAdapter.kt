package com.ariqandrean.daftaraplikasiinvestojk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(val context: Context, var dataList: ArrayList<HospitalsModel>?)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val llMain = view.llMain
        val tvName = view.tvName
        val tvAddress = view.tvAddress
        val tvRegion = view.tvRegion
        val tvPhone = view.tvPhone
        val tvProvinsi = view.tvProvince
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList!!.get(position)

//        holder.tvId.text = (position + 1).toString()
//        holder.tvName.text = "(id:${item?.id.toString()}) ${item?.name.toString()}"
        holder.tvName.text = item.name.toString()
        holder.tvAddress.text = item.address.toString()
        holder.tvRegion.text = item.region.toString()
        holder.tvPhone.text = item.phone
        holder.tvProvinsi.text = item.province.toString()

//        if (position % 2 == 0){
//            holder.llMain.setBackgroundColor(ContextCompat.getColor(context, R.color.teal_200))
//        } else {
//            holder.llMain.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
//        }
    }
}