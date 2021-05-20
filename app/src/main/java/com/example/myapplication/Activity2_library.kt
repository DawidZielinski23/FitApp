package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2LibraryBinding

class Activity2_library: AppCompatActivity() {
    private lateinit var binding: Activity2LibraryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_library)
        binding = DataBindingUtil.setContentView(this,R.layout.activity2_library)
    }
}