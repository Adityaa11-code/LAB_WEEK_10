package com.example.lab_week_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class FirstFragment : Fragment() {

    private lateinit var textTotalFragment: TextView

    private val viewModel: TotalViewModel by lazy {
        ViewModelProvider(requireActivity())[TotalViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        textTotalFragment = view.findViewById(R.id.text_total_fragment)
        updateTotalText(viewModel.total)
        return view
    }

    fun refresh() {
        updateTotalText(viewModel.total)
    }

    private fun updateTotalText(value: Int) {
        textTotalFragment.text = "Total: $value"
    }
}
