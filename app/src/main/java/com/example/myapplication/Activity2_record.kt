package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Activity2MainBinding

class Activity2_record: AppCompatActivity() {
    private lateinit var binding: Activity2_record
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_record)
    }
}