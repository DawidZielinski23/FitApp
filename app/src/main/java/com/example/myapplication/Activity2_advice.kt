package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.myapplication.databinding.Activity2MainBinding

class Activity2_advice: AppCompatActivity() {
    private lateinit var binding: Activity2MainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity2_main)
    }
}