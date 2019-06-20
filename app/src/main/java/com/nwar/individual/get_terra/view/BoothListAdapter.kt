package com.nwar.individual.get_terra.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nwar.individual.get_terra.R

class BoothListAdapter (val context : Context, val list : List<BoothInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if(p0 is ViewHolder){
            p0.bind(list[p1])
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.boothlist_item,p0,false))
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val textView = v.findViewById<TextView>(R.id.list_boothlist_item_tv)
        fun bind(info : BoothInfo){
            if(info.takeTeam!=null){
                textView.setTextColor(info.takeTeam)
            }
            textView.text = info.boothName
        }
    }
}