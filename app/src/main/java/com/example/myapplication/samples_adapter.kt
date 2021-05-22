package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class samples_adapter(private val context:Context, private val activities:ArrayList<samples_row>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val single_row = LayoutInflater.from(context).inflate(R.layout.activity2_samples_row, parent,false)
        single_row.findViewById<TextView>(R.id.name).setText(activities[position].name)
        single_row.findViewById<TextView>(R.id.value).setText(activities[position].value)
        single_row.findViewById<TextView>(R.id.description).setText(activities[position].description)
        return single_row
    }

    override fun getItem(position: Int): Any {
        return activities[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return activities.size
    }

}