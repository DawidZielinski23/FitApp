package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2MainBinding
import com.example.myapplication.databinding.Activity2RecordBinding

class Activity2_record: AppCompatActivity() {
    private lateinit var binding: Activity2RecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_record)
        binding= DataBindingUtil.setContentView(this, R.layout.activity2_record)
        val text = intent.getStringExtra("name").toString()
        binding.textView.setText(text)
    }
}