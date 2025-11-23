package com.example.lab_week_10   // <- sesuaikan dengan package project lu, cek di baris paling atas sebelumnya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCounterTop = findViewById<TextView>(R.id.tvCounterTop)
        val tvCounterBottom = findViewById<TextView>(R.id.tvCounterBottom)
        val btnPressMe = findViewById<Button>(R.id.btnPressMe)

        btnPressMe.setOnClickListener {
            counter++
            val text = "Total: $counter"
            tvCounterTop.text = text
            tvCounterBottom.text = text
        }
    }
}
