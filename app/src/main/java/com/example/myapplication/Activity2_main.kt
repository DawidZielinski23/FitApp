package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2MainBinding

class Activity2_main : AppCompatActivity() {
    private lateinit var binding: Activity2MainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity2_main)
        binding.activity2MainLabel.setText("TRENING SIŁOWY")
        binding.activity2MainDescription.setText("Trening siłowy ma na celu obciążenie Twojego układu mięsniowego i neurologicznego, aby osiągnąć wyznaczony cel. " + "\n\n" +
                "Poniżej znajdziesz bazę ćwiczeń na różne partię mieśni oraz przykładowe plany treningowe. ")

        binding.activity2Library.setOnClickListener(){
            val intent2_library = Intent(this,Activity2_library::class.java)
            startActivity(intent2_library)
        }
        binding.activity2Samples.setOnClickListener(){
            val intent2_samples = Intent(this,Activity2_samples::class.java)
            startActivity(intent2_samples)
        }
    }
}