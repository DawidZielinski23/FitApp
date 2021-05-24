package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2LibraryBinding

class Activity2_library: AppCompatActivity() {
    private lateinit var binding: Activity2LibraryBinding
    private val activities:ArrayList<library_row> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_library)
        binding = DataBindingUtil.setContentView(this,R.layout.activity2_library)
        binding.activity2LibraryLabel.setText("BIBLIOTEKA TRENINGÓW")
        activities.add(library_row("Rozgrzewka","Rodzaj treningu","ogólnorowojowy","r1"))
        activities.add(library_row("Rozciąganie","Rodzaj treningu","ogólnorowojowy","r2"))


        val activities_adapter = library_adapter(this,activities)
        binding.activity2LibraryList.adapter=activities_adapter
        binding.activity2LibraryList.setOnItemClickListener{ parent: AdapterView<*>?, view: View?, position :Int, id: Long ->
            var intent = Intent(this, Activity2_record::class.java)
            var storage:String = activities[position].Id
            intent.putExtra("id",storage)
            startActivity(intent)
        }
    }
}