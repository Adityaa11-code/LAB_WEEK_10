package com.example.lab_week_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lab_week_10.database.Total
import com.example.lab_week_10.database.TotalDatabase
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import com.example.lab_week_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dao by lazy { TotalDatabase.getDatabase(this).totalDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        binding.buttonIncrement.setOnClickListener {
            updateTotal()
        }
    }

    private fun loadData() {
        lifecycleScope.launch {
            val saved = dao.getTotal()
            binding.textTotal.text = "Total: ${saved?.total ?: 0}"
            binding.textTimestamp.text = "Last Updated: ${saved?.timestamp ?: "-"}"
        }
    }

    private fun updateTotal() {
        lifecycleScope.launch {
            val saved = dao.getTotal()
            val newTotal = (saved?.total ?: 0) + 1

            val time = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())
            val data = Total(1, newTotal, time)

            dao.insert(data)
            loadData()
        }
    }
}
