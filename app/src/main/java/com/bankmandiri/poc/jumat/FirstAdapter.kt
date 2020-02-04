package com.bankmandiri.poc.jumat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class FirstAdapter (val employess:ArrayList<Employee>, val context:Context) : RecyclerView.Adapter<FirstAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
    return Holder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false))
    }

    override fun getItemCount(): Int = employess.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(employess[position])

    }

    inner class Holder(val view : View) : RecyclerView.ViewHolder(view){
        fun bind(employess: Employee){
            view.textView.text= employess.name
        }
    }
}