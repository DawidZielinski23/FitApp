package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class library_adapter(private val context: Context, private val activities:ArrayList<library_row>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val library_row = LayoutInflater.from(context).inflate(R.layout.activity2_library_row, parent,false)
        library_row.findViewById<TextView>(R.id.library_name).setText(activities[position].name)
        library_row.findViewById<TextView>(R.id.library_muscle).setText(activities[position].muscle)
        library_row.findViewById<TextView>(R.id.library_description).setText(activities[position].description)
        return library_row
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