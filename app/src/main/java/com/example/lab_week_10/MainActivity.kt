package com.example.lab_week_10

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var textTotal: TextView
    private lateinit var buttonPressMe: Button

    // ViewModel supaya total nggak reset saat rotate
    private val viewModel: TotalViewModel by lazy {
        ViewModelProvider(this)[TotalViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTotal = findViewById(R.id.text_total)
        buttonPressMe = findViewById(R.id.button_press_me)

        // set tampilan awal dari ViewModel
        updateTotalText(viewModel.total)

        buttonPressMe.setOnClickListener {
            val newTotal = viewModel.incrementTotal()
            updateTotalText(newTotal)
        }
    }

    private fun updateTotalText(value: Int) {
        textTotal.text = "Total: $value"
    }
}
