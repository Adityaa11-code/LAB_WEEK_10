package com.example.lab_week_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab_week_10.databinding.FragmentFirstBinding
import com.example.lab_week_10.viewmodels.TotalViewModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TotalViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get ViewModel dari Activity
        viewModel = ViewModelProvider(requireActivity())[TotalViewModel::class.java]

        // Observe LiveData
        viewModel.total.observe(viewLifecycleOwner) { total ->
            binding.textFragment.text = "Fragment Total: $total"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
